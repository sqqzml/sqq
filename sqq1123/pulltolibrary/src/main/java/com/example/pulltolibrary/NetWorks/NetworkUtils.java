package com.example.wifinetworkdemo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/**
boolean isNet = NetworkUtils.getNetwork(this);
if (isNet)
{youwang
}else{
	meiwang
}*/
public class NetworkUtils {
    //为什么要串上下文对象  因为这是一个单独java类所以获取不到Android
    public static boolean getNetwork(Context context) {
        boolean boo = false;
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

}
