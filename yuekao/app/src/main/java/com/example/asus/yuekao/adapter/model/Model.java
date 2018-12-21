package com.example.asus.yuekao.adapter.model;

import com.example.asus.yuekao.adapter.callBack.MyCallBack;

public interface Model {
    void  requestData(String mUrl, int page, MyCallBack myCallBack);
}
