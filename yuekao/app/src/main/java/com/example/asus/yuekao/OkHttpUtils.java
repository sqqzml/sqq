package com.example.asus.yuekao;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {
    private OkHttpClient okHttpClient=new OkHttpClient();

    public static OkHttpUtils getInsatance(){
        return OkHolder.okUtils;
    }
    static class OkHolder {
        private static final OkHttpUtils okUtils = new OkHttpUtils();
    }
    public void getAsync(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void postAsync( String url,int page, Callback callback) {
        RequestBody body = new FormBody.Builder().add("page", page+"").build();
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
