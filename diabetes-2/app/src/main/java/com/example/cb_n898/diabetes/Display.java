package com.example.cb_n898.diabetes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cb_n898 on 24/2/2559.
 */
public class Display extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        DatabaseHelper helper = new DatabaseHelper(this);

        String username = getIntent().getStringExtra("Username");
        String password = getIntent().getStringExtra("Password");
        String[] strArray  =  helper.SearchPassArray(username, password);


        TextView textView = (TextView)findViewById(R.id.tvUser);
        textView.setText(strArray[0]);

        TextView textView1 = (TextView)findViewById(R.id.tvName);
        textView1.setText(strArray[1]);

        TextView textView2 = (TextView)findViewById(R.id.tvAge);
        textView2.setText(strArray[2]);

        TextView textView3 = (TextView)findViewById(R.id.tvSex);
        textView3.setText(strArray[3]);

        TextView textView4 = (TextView)findViewById(R.id.tvWeight);
        textView4.setText(strArray[4]);

        TextView textView5 = (TextView)findViewById(R.id.tvHeight);
        textView5.setText(strArray[5]);

        TextView textView6 = (TextView)findViewById(R.id.tvLevel);
        textView6.setText(strArray[6]);

    }

    public void onClickMenu(View v){

        Intent i = new Intent(Display.this, Menu.class);
            startActivity(i);
    /*    DatabaseHelper helper = new DatabaseHelper(this);
        String[] strArray  =  helper.SearchPassArray("","");
        Log.d("strArray", strArray[0]+"");
        Log.d("strArray1", strArray[1]+"");   */

    }

}
