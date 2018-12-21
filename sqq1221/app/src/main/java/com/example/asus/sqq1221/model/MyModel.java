package com.example.asus.sqq1221.model;

import android.os.Handler;
import android.os.Message;

import com.example.asus.sqq1221.OkHttpUtils;
import com.example.asus.sqq1221.adapter.MyCallBack;
import com.example.asus.sqq1221.adapter.MyData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyModel implements Model {
    private MyCallBack myCallBack;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            Gson gson = new Gson();
            MyData myData = gson.fromJson(obj, MyData.class);
            myCallBack.Success(myData);
        }
    };
    @Override
    public void requestData(final String mUrl, final String page, MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtils.getInsatance().postAsync(mUrl,page, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();
                        mHandler.sendMessage(mHandler.obtainMessage(0,s));
                    }


                });
            }
        }).start();
    }
}
