package com.example.asus.month1221.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private OkHttpClient okHttpClient=new OkHttpClient();
    //日志拦截器
    private OkHttpUtils(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        okHttpClient=new OkHttpClient.Builder().
                connectTimeout(2000,TimeUnit.SECONDS)
                .callTimeout(2000,TimeUnit.SECONDS)
                .readTimeout(2000,TimeUnit.SECONDS).
                addInterceptor(httpLoggingInterceptor)
                .build();

    }

    //使用单lie模式
    public static OkHttpUtils getInstance(){

        return OkHttpHolder.okhttpclient;
    }

    static class OkHttpHolder{
        private  final  static OkHttpUtils okhttpclient=new OkHttpUtils();
    }

    //使用异步get请求方式
    public void getAsync(String mUrl, Callback callback){
        Request request = new Request.Builder().url(mUrl).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //使用异步post请求方式
    public void postAsync(String mUrl,String keyWords,String page,Callback callback){
        FormBody formBody = new FormBody.Builder().add("keywords", keyWords)
                .add("page",page)
                .build();
        Request request = new Request.Builder().url(mUrl).post(formBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
