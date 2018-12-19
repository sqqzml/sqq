package com.example.asus.sqq.utils;

import com.example.asus.sqq.callBack.CallBack;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {

    public OkHttpClient okHttpClient;

    private OkHttpUtils(){
         okHttpClient = new OkHttpClient();
    }

    public static OkHttpUtils getInstance(){
        return OkHttpHolder.okHttpUtils;
    }
    public static class OkHttpHolder{
        public static final  OkHttpUtils okHttpUtils=new OkHttpUtils();
    }
    //采用异步Post的方法
    public void post(String uri, String keyword, String page, String sort, Callback callBack){
      RequestBody requestBody = new FormBody.Builder()
              .add("keywords",keyword)
              .add("page",page)
              .add("sort",sort)
              .build();
        Request request = new Request.Builder().url(uri).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callBack);
    }
    //get方式进行请求数据
    public void get(String uri,Callback callback){
        Request build = new Request.Builder().url(uri).build();
        okHttpClient.newCall(build).enqueue(callback);
    }
}
