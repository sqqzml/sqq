package com.example.asus.month1221.callback;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.month1221.bean.MyData;
import com.example.asus.month1221.bean.MyData2;
import com.example.asus.month1221.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyModel2 implements Model2 {
    private MyCallBack myCallBack;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          String   S = (String) msg.obj;
            Gson gson = new Gson();
            MyData2 myData = gson.fromJson(S, MyData2.class);

            myCallBack.success(myData);



        }
    };

    @Override
    public void request(final String url, final String keywords, final String page, final MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        new Thread(new Runnable() {
            @Override
            public void run() {
              OkHttpUtils.getInstance().postAsync(url, keywords, page, new Callback() {
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

 /*   @Override
    public void request(final String murl,String  MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
    //通过OkHttp记性数据解析
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtils.getInstance().getAsync(murl, new okhttp3.Callback() {
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

    @Override
    public void request(String murl, MyCallBack myCallBack) {
        this.myCallBack=myCallBack
    }*/
}
