package com.example.cb_n898.diabetes;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by cb_n898 on 14/3/2559.
 */
public class AndroidTimeActivity extends Activity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    Button buttonCancelAlarm;
    TextView textAlarmPrompt;

    TimePicker timePicker;
    CheckBox optRepeat;

    final static int RQS_1 = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pill);

        timePicker = (TimePicker)findViewById(R.id.picker);
        optRepeat = (CheckBox)findViewById(R.id.optrepeat);
        textAlarmPrompt = (TextView)findViewById(R.id.alarmprompt);

        buttonstartSetDialog = (Button)findViewById(R.id.startSetDialog);
        buttonstartSetDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Calendar calNow = Calendar.getInstance();
                Calendar calSet = (Calendar) calNow.clone();

                calSet.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calSet.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                calSet.set(Calendar.SECOND, 0);
                calSet.set(Calendar.MILLISECOND, 0);

                if(calSet.compareTo(calNow) <= 0){
                    //Today Set time passed, count to tomorrow
                    calSet.add(Calendar.DATE, 1);
                }

                setAlarm(calSet, optRepeat.isChecked());

            }});

        buttonCancelAlarm = (Button)findViewById(R.id.cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                cancelAlarm();
            }});

    }

    private void setAlarm(Calendar targetCal, boolean repeat){

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

        if(repeat){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    targetCal.getTimeInMillis(),
                    TimeUnit.HOURS.toMillis(5),
                    pendingIntent);

            textAlarmPrompt.setText(
                    "\n\n********************\n"
                            + "Alarm is set@ " + targetCal.getTime() + "\n"
                            + "Repeat every 1 hours\n"
                            + "********************\n");
        }else{
            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    targetCal.getTimeInMillis(),
                    pendingIntent);

            textAlarmPrompt.setText(
                    "\n\n********************\n"
                            + "Alarm is set@ " + targetCal.getTime() + "\n"
                            + "One shot\n"
                            + "********************\n");
        }

    }

    private void cancelAlarm(){

        textAlarmPrompt.setText(
                "\n\n********************\n"
                        + "Alarm Cancelled! \n"
                        + "********************\n");

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

    }

}
