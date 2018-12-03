package com.example.asus.sqq1203.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asus.sqq1203.helper.MyHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDao {

    private final SQLiteDatabase sd;

    public MyDao(Context context){
        MyHelper myHelper = new MyHelper(context);
        sd = myHelper.getWritableDatabase();
    }
    //查询
    public ArrayList<String> setName(){
        ArrayList<String> list = new ArrayList<>();
        Cursor query = sd.query("shops", null, null, null, null, null, null);
        while (query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            list.add(name);
        }
        return list;
    }
    //添加
    public void insert(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        sd.insert("shops",null,values);
    }
    //删除
    public  void delete(){
       sd.delete("shops",null,null);
    }
}
