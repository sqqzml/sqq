package com.example.asus.sqq1203;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.sqq1203.dao.MyDao;
import com.example.asus.sqq1203.view.FlowView;
import com.example.asus.sqq1203.view.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = {"基础护肤", "面部清洁", "面膜", "兰蔻", "雅诗兰黛", "资生堂", "眼部护理", "悦诗风吟", "美容护肤"};
    private ArrayList<String> mHistory= new ArrayList<>();
    private ArrayList<String> mList= new ArrayList<>();
    private TitleView title;
    private TextView del;
    private FlowView history_flowView;
    private FlowView flowView;
    private MyDao dao;
    private TextView zuijin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        dao = new MyDao(this);
         mHistory= dao.setName();
        if (mHistory!=null){
        history_flowView.setData(mList);
        }
    }
    private void initData() {
        for (int i = 0; i <data.length ; i++) {
           mList.add(data[i]);
        }
    }
    private void initView() {
        title = (TitleView) findViewById(R.id.title);
        del = (TextView) findViewById(R.id.del);
        history_flowView = (FlowView) findViewById(R.id.history_flowView);
        flowView = (FlowView) findViewById(R.id.flowView);
        zuijin = findViewById(R.id.zuijin);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //进行添加的方法
            case R.id.add:
                String s = title.getSs().trim();
                mHistory.add(s);
                history_flowView.removeAllViews();
                dao.insert(s);
                history_flowView.setData(mHistory);
                break;
                //进行删除
            case R.id.del:
                dao.delete();
                history_flowView.removeAllViews();
                break;
            case R.id.zuijin:
                Toast.makeText(MainActivity.this,"哈哈",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
