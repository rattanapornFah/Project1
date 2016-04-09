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
        setContentView(R.layout.activity_menu);

     /*   String name = getIntent().getStringExtra("Name");
        TextView textView1 = (TextView)findViewById(R.id.tvName);
        textView1.setText(name);

        String age = getIntent().getStringExtra("Age");
        TextView textView2 = (TextView)findViewById(R.id.tvAge);
        textView2.setText(age);

        String gender = getIntent().getStringExtra("Gender");
        TextView textView3 = (TextView)findViewById(R.id.tvSex);
        textView3.setText(gender);

        String level = getIntent().getStringExtra("Level");
        TextView textView6 = (TextView)findViewById(R.id.tvLevel);
        textView6.setText(level);   */
    }

    public void onClickRecord(View v){

        Intent i = new Intent(Menu.this, Record.class);
        startActivity(i);
    }


}
