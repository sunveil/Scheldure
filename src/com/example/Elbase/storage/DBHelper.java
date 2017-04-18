package com.example.Elbase.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.Elbase.utils.DBConst;

import java.sql.Date;


/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String TABLE_NAME = "SCHELDURE";
    public static final String SCHELDURE_TABLE_ID = "ID";
    public static final String SCHELDURE_TABLE_NAME = "NAME";
    public static final String SCHELDURE_TABLE_START = "START";
    public static final String SCHELDURE_TABLE_END = "END";
    public static final String SCHELDURE_TABLE_AUDITORIUM = "AUDITORIUM";

    public DBHelper(Context context) {
        super(context, DBConst.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +  TABLE_NAME +
                        "(id integer primary key, start date,end date,name text, auditirium text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData(int id){  
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from contacts where id="+id+"", null);
        return res;
    }

    public boolean insertLecture(String name, Date start, Date end, String auditorium) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHELDURE_TABLE_NAME, name);
        contentValues.put(SCHELDURE_TABLE_START, String.valueOf(start));
        contentValues.put(SCHELDURE_TABLE_END, String.valueOf(end));
        contentValues.put(SCHELDURE_TABLE_AUDITORIUM, auditorium);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

}
