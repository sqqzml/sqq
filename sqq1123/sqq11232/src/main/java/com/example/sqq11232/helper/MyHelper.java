package com.example.sqq11232.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context) {
        super(context, "mydb", null, 1);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        String exsql="create table news(title text)";
        db.execSQL(exsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
