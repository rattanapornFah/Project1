package com.example.cb_n898.diabetes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    DatabaseHelper helper = new DatabaseHelper(this);

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        navList = (ListView)findViewById(R.id.navlist);
        ArrayList<String> navArray = new ArrayList<String>();
        navArray.add("หน้าหลัก");
        navArray.add("ประวัติ");
        navArray.add("คำนวณดัชนีน้ำตาลในอาหาร");
        navArray.add("แจ้งเตือน");
        navArray.add("บันทึกอาการ");
        navArray.add("กราฟ");
        navArray.add("สาระน่ารู้");
        navArray.add("เมนูอาหาร");

        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        loadSelection(0);

    }

    private void loadSelection(int i){
        navList.setItemChecked(i,true);

        switch(i){
            case 0:
                SignUp SignUp = new SignUp();
                //  FragmentTransaction replace = fragmentTransaction.replace(R.id.fragmentholder, com.example.cb_n898.diabetes.SignUp);
                fragmentTransaction.commit();
                break;
            case 1:
              //  Menu Menu = new Menu();
              //  FragmentTransaction replace = fragmentTransaction.replace(R.id.fragmentholder, com.example.cb_n898.diabetes.SignUp);
                fragmentTransaction.commit();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
        }

    }

    @Override
    protected  void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }else if (id == android.R.id.home){
            if(drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            }else {
                drawerLayout.openDrawer(navList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        switch(position){
            case 0:

                break;
            case 1:
                loadSelection(position);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
        }
        drawerLayout.closeDrawer(navList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void  onButtonClick(View v){
        if(v.getId()==R.id.btn_login){
            EditText a = (EditText)findViewById(R.id.et_email);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.et_pass);
            String pass = b.getText().toString();

            Log.d(str,pass);
try {
    //String password = helper.searchPass(str);
    String[] strArray = helper.SearchPassArray(str, pass);

if(str.equals("") || pass.equals("")|| str.equals(null) || pass.equals(null)){
    Toast temp = Toast.makeText(MainActivity.this, "Username and Passwords don't match!", Toast.LENGTH_SHORT);
    temp.show();
}
    else if(strArray!=null && strArray.length>0  ){
        Intent i = new Intent(MainActivity.this, Display.class);
        i.putExtra("Username", str);
        i.putExtra("Password",pass);

        startActivity(i);

    }else if(strArray==null ){
        Toast temp = Toast.makeText(MainActivity.this, "Username and Passwords don't match!", Toast.LENGTH_SHORT);
        temp.show();
    }


//            if(pass.equals("")) {
//                Toast temp = Toast.makeText(MainActivity.this, "Username and Passwords don't match!", Toast.LENGTH_SHORT);
//                temp.show();
//            }
//            else if(pass.equals(password)) {
//                Intent i = new Intent(MainActivity.this, Display.class);
//                i.putExtra("Username", str);
//                startActivity(i);
//            }
//
//            else {
//                Toast temp = Toast.makeText(MainActivity.this, "Username and Passwords don't match!", Toast.LENGTH_SHORT);
//                temp.show();
//            }
//        }
}catch (Exception e){

}
        }
        if(v.getId()==R.id.btn_register){
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }

}
