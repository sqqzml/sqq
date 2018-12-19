package com.example.asus.sqq.model;

import com.example.asus.sqq.callBack.CallBack;

public interface Model {
    void GetData(String uri, String keyword, String page, String sort, CallBack callBack);
}
