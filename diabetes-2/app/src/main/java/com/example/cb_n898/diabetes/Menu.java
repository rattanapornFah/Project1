package com.example.cb_n898.diabetes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by cb_n898 on 6/3/2559.
 */
public class Menu extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dashboard);

    }

    public void onClickRecord(View v){

        Intent i = new Intent(Menu.this, Record.class);
        startActivity(i);
    }

    public void onClickAlert(View v){
        Intent i = new Intent(Menu.this, Alert.class);
        startActivity(i);
    }

    public void onClickInfo(View v){
        Intent i = new Intent(Menu.this, Information.class);
        startActivity(i);
    }

}
