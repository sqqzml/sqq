package com.example.asus.month1221.callback;

import android.os.Handler;
import android.os.Message;

import com.example.asus.month1221.bean.MyData;
import com.example.asus.month1221.bean.MyData2;
import com.example.asus.month1221.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class MyModel implements Model {
    private MyCallBack myCallBack;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          String   S2 = (String) msg.obj;
            Gson gson = new Gson();
            MyData myData = gson.fromJson(S2, MyData.class);
            myCallBack.success(myData);


        }
    };

    @Override
    public void request(final String murl, MyCallBack myCallBack) {
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


}
