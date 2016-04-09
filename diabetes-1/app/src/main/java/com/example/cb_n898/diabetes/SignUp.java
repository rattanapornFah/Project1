package com.example.cb_n898.diabetes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends Activity implements RadioGroup.OnCheckedChangeListener {

   private String gender;
   private  String level;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)radioGroup.findViewById(radioButtonId);
        gender = radioButton.getText().toString();
        level = radioButton.getText().toString();
    }

    public void onSignUpClick(View v) {


        if (v.getId() == R.id.btn_register2) {


//            RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.r_sex);
            //radioGroupGender.setOnCheckedChangeListener(this);

            RadioGroup radioGroupLevel = (RadioGroup) findViewById(R.id.r_level);
            radioGroupLevel.setOnCheckedChangeListener(this);
            RadioButton male = (RadioButton)findViewById(R.id.radioMale);
            RadioButton female = (RadioButton)findViewById(R.id.radioFemale);

            RadioButton in = (RadioButton)findViewById(R.id.radioIn);
            RadioButton no = (RadioButton)findViewById(R.id.radioNo);

            EditText name = (EditText) findViewById(R.id.etName);
            EditText age = (EditText) findViewById(R.id.etAge);

            EditText weight = (EditText) findViewById(R.id.etWeight);
            EditText height = (EditText) findViewById(R.id.etHeight);

            EditText email = (EditText) findViewById(R.id.etEmail);
            EditText uname = (EditText) findViewById(R.id.etUser);
            EditText pass1 = (EditText) findViewById(R.id.etPass);
            EditText pass2 = (EditText) findViewById(R.id.etConfirm);


            String genderstr =""; //radioGroupGender.toString();
            String levelstr = "";
         //   String levelstr = radioGroupLevel.toString();

            String namestr = name.getText().toString();
            String agestr = age.getText().toString();
            String weightsrt = weight.getText().toString();
            String heightste = height.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();


            if(male.isChecked()){
                genderstr = "ชาย";
            }else if(female.isChecked()){
                genderstr = "หญิง";
            }else{
                genderstr = "";
            }

            if(in.isChecked()){
                levelstr = "พึ่งอินซูลิน";
            }else if(no.isChecked()){
                levelstr = "ไม่พึ่งอินซูลิน";
            }else{
                levelstr = "";
            }

            Log.d("genderstr >>>>>",genderstr+"");

            if (!pass1str.equals(pass2str)) {
                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            } else {
                Contact c = new Contact();
                c.setName(namestr);
                c.setAge(agestr);
                c.setGender(genderstr);
                c.setWeight(weightsrt);
                c.setHeight(heightste);
                c.setLevel(levelstr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
            }
        }
    }

}
