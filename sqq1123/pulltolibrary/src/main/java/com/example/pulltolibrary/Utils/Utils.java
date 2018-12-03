package com.example.week3.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static String getStr(String mUrl) throws Exception {
        URL url = new URL(mUrl);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(5000);
        InputStream stream = urlConnection.getInputStream();
        String s = getString(stream);
        return s;
    }

    private static String getString(InputStream stream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuffer buffer = new StringBuffer();
        String con="";
        while ((con=reader.readLine())!=null){
            buffer.append(con);
        }
        return buffer.toString();
    }
}
