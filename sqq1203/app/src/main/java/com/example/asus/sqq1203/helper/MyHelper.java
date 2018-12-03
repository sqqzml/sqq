package com.example.asus.sqq1203.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {


    public MyHelper(Context context){
        super(context, "mydb", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        db.execSQL("create table shops(name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
