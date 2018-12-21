package com.example.asus.month1221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private String[] mImages = {
            "http://www.zhaoapi.cn//images//quarter//ad2.png",
            "http://www.zhaoapi.cn//images//quarter//ad3.png",
            "http://www.zhaoapi.cn//images//quarter//ad4.png"};
    private FlyBanner flyBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       ArrayList<String> mUrlList=new ArrayList<>();
        for (int i = 0; i <mImages.length ; i++) {
         mUrlList.add(mImages[i]);
        }
        flyBanner.setImagesUrl(mUrlList);
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        flyBanner = (FlyBanner) findViewById(R.id.flyBanner);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
