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

        String username = getIntent().getStringExtra("Username");
        TextView textView = (TextView)findViewById(R.id.tvUser);
        textView.setText(username);

   /*     String name = getIntent().getStringExtra("Name");
        TextView textView1 = (TextView)findViewById(R.id.tvName);
        textView1.setText(name);

        String age = getIntent().getStringExtra("Age");
        TextView textView2 = (TextView)findViewById(R.id.tvAge);
        textView2.setText(age);

        String gender = getIntent().getStringExtra("Gender");
        TextView textView3 = (TextView)findViewById(R.id.tvSex);
        textView3.setText(gender);

        String weight = getIntent().getStringExtra("Weight");
        TextView textView4 = (TextView)findViewById(R.id.tvWeight);
        textView4.setText(weight);

        String height = getIntent().getStringExtra("Height");
        TextView textView5 = (TextView)findViewById(R.id.tvHeight);
        textView5.setText(height);

        String level = getIntent().getStringExtra("Level");
        TextView textView6 = (TextView)findViewById(R.id.tvLevel);
        textView6.setText(level);  */

    }

    public void onClickMenu(View v){

        TextView textView1 = (TextView)findViewById(R.id.tvUser);
        String str = textView1.getText().toString();
     /*   TextView textView2 = (TextView)findViewById(R.id.tvAge);
        String str2 = textView2.getText().toString();
        TextView textView3 = (TextView)findViewById(R.id.tvSex);
        String str3 = textView3.getText().toString();
        TextView textView6 = (TextView)findViewById(R.id.tvLevel);
        String str6 = textView6.getText().toString();  */


        Intent i = new Intent(Display.this, Menu.class);
        i.putExtra("Username", str);
      //  i.putExtra("Age", str2);
      //  i.putExtra("Gender", str3);
      //  i.putExtra("Level", str6);
            startActivity(i);
    }

}
