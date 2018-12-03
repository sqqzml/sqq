package com.example.sqq11232.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorks {
    //判断是否有网
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
