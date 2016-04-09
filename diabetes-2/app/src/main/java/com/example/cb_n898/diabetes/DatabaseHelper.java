package com.example.cb_n898.diabetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cb_n898 on 24/2/2559.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_LEVEL = "level";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS  ="pass";


    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "name text not null , email text not null , uname text not null , pass text not null, age text not null," +
            "weight text not null, height text not null, level text not null, gender text not null   );";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID , count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_GENDER, c.getGender());
        values.put(COLUMN_WEIGHT, c.getWeight1());
        values.put(COLUMN_HEIGHT, c.getHeight());
        values.put(COLUMN_LEVEL, c.getLevel());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    // Select Data form UserName and Passwaord
    public String[] SearchPassArray(String uname,String pass) {


        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_NAME, new String[] { "uname,name,age,gender,weight,height,level" },
                    "uname=? AND pass=?",
                    new String[] { String.valueOf(uname),String.valueOf(pass) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                    arrData[6] = cursor.getString(6);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }
 /*   public Cursor getAllData(){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);

        return cursor;
    }


    public String[] searchPass(String id)
    {
        try {

            String arrData[] = null;

            SQLiteDatabase db;

            db = this.getReadableDatabase(); // Read Data


            Cursor cursor = db.query(TABLE_NAME, new String[] { "*" },

                    "id=?",

                    new String[] { String.valueOf(id) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {

                    arrData = new String[cursor.getColumnCount()];


                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                    arrData[6] = cursor.getString(6);

                }

            }

            cursor.close();

            db.close();

            return arrData;

        } catch (Exception e) {

            return null;

        }
    }

    public ArrayList<HashMap<String, String>> SelectAllData() {

        try {
            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("Name", cursor.getString(1));
                        map.put("Age", cursor.getString(2));
                        map.put("Gender", cursor.getString(3));
                        map.put("Weight", cursor.getString(4));
                        map.put("Height", cursor.getString(5));
                        map.put("Level", cursor.getString(6));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;
        } catch (Exception e) {
            return null;
        }
    }
*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXITS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}
