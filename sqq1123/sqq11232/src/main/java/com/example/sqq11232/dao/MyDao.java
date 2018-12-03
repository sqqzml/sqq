package com.example.sqq11232.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqq11232.helper.MyHelper;

public class MyDao  {

    private final MyHelper helper;
    private final SQLiteDatabase db;

    public MyDao(Context context){
        helper = new MyHelper(context);
        db = helper.getWritableDatabase();
    }
    //查询
    public String select(){
        Cursor cursor = db.query("news", null, null, null, null, null, null);
        return cursor+"";
    }
    //添加
    public String insert(String s){
        ContentValues values = new ContentValues();
        values.put("title",s);
        long news = db.insert("news", null, values);
        return news+"";
    }
}
