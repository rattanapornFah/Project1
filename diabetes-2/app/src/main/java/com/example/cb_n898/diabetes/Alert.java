package com.example.cb_n898.diabetes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import com.example.cb_n898.diabetes.NoteDoctor.NoteMainActivity;


/**
 * Created by cb_n898 on 13/3/2559.
 */
public class Alert extends Activity {
    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

    }

    public void onClickAlertPill(View v){
        Intent i = new Intent(Alert.this, AndroidTimeActivity.class);
        startActivity(i);
    }

    public void onClickDoctor(View v){
        Intent i = new Intent(Alert.this, NoteMainActivity.class);
        startActivity(i);
    }


}
