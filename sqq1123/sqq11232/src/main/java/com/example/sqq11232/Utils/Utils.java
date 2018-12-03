package com.example.sqq11232.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Utils {
    public static String getStr(String mUrl) throws Exception {
        URL url = new URL(mUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setConnectTimeout(5000);
        InputStream stream = connection.getInputStream();
        String s = getInPutStream(stream);
        return s;
    }

    private static String getInPutStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        String con="";
        while ((con=reader.readLine())!=null){
            builder.append(con);
        }
        return builder.toString();
    }
}
