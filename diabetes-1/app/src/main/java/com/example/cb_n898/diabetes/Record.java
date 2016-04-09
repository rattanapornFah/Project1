package com.example.cb_n898.diabetes;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by cb_n898 on 9/3/2559.
 */
public class Record  extends AppCompatActivity implements View.OnClickListener {

    Button btnTime, btnDate;
    TextView tvTime, tvDate;

    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;

    Calendar calendar = Calendar.getInstance();

    DatabaseHelperRecord helper = new DatabaseHelperRecord(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        btnTime = (Button) findViewById(R.id.button);
        btnTime.setOnClickListener(this);
        btnDate = (Button) findViewById(R.id.button2);
        btnDate.setOnClickListener(this);

        tvTime = (TextView) findViewById(R.id.tvTime);
        tvDate = (TextView) findViewById(R.id.tvDate);

    }

    @Override
    public void onClick(View v) {

        calendar = Calendar.getInstance();

        switch (v.getId()){

            case R.id.button:{

                timePickerDialog = new TimePickerDialog(Record.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        timeCalendar.set(Calendar.MINUTE, minute);

                            String timestring = DateUtils.formatDateTime(Record.this, timeCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);
//                            Log.d("time", timestring);

                        tvTime.setText("Time : " + timestring);

                    }
                },calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), android.text.format.DateFormat.is24HourFormat(Record.this));

                timePickerDialog.show();
                break;
            }

            case R.id.button2:{

                datePickerDialog = new DatePickerDialog(Record.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Calendar dateCalendar = Calendar.getInstance();
                        dateCalendar.set(Calendar.YEAR, year);
                        dateCalendar.set(Calendar.MONTH, monthOfYear);
                        dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String dateString = DateUtils.formatDateTime(Record.this, dateCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);
                        tvDate.setText("Date : " + dateString);

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
                break;
            }


        }

    }

    public void onSaveClick(View v) {


        if (v.getId() == R.id.btn_save) {

            TextView time = (TextView) findViewById(R.id.tvTime);
            TextView date = (TextView) findViewById(R.id.tvDate);
            EditText pres = (EditText) findViewById(R.id.et1);
            EditText sugar = (EditText) findViewById(R.id.et2);
            EditText cho = (EditText) findViewById(R.id.et3);
            EditText weight = (EditText) findViewById(R.id.et4);

            String timestr = time.getText().toString();
            String datestr = date.getText().toString();
            String presstr = pres.getText().toString();
            String sugarstr = sugar.getText().toString();
            String chostr = cho.getText().toString();
            String weightstr = weight.getText().toString();

            if (datestr.equals(datestr)) {
                Toast pass = Toast.makeText(Record.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();

            } else {
                Contact con = new Contact();
            con.setTime(timestr);
            con.setDate(datestr);
            con.setPres(presstr);
            con.setSugar(sugarstr);
            con.setCho(chostr);
            con.setWeight(weightstr);

                helper.insertContact(con);

            }
        }
    }


}
