package com.example.cb_n898.diabetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cb_n898 on 12/3/2559.
 */
public class DatabaseHelperRecord extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "records.db";
    private static final String TABLE_NAME = "record";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_PRESSURE = "pressure";
    private static final String COLUMN_SUGAR = "sugar";
    private static final String COLUMN_CHOLESTEROL = "cholesterol";
    private static final String COLUMN_WEIGHT = "weight";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table record (id integer primary key not null , " +
            "time text not null , date text not null , pressure text not null , sugar text not null,cholesterol text not null, weight text not null);";


    public DatabaseHelperRecord(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

        this.db=db;
    }

    public long insertContact(Contact con) {
        try {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID , count);
        values.put(COLUMN_TIME, con.getTime());
        values.put(COLUMN_DATE, con.getDate());
        values.put(COLUMN_PRESSURE, con.getPres());
        values.put(COLUMN_SUGAR, con.getSugar());
        values.put(COLUMN_CHOLESTEROL, con.getCho());
        values.put(COLUMN_WEIGHT, con.getWeight());

        db.insert(TABLE_NAME, null, values);
        db.close();
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public String searchPass(String id)
    {
        db = this.getReadableDatabase();
        String query = "select id, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(id))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXITS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
