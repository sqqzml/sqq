package com.example.asus.sqq1221.model;

import com.example.asus.sqq1221.adapter.MyCallBack;

public interface Model {
    void  requestData(String mUrl, String page, MyCallBack myCallBack);
}

