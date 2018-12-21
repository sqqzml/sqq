package com.example.asus.sqq1221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.asus.sqq1221.adapter.MyAdapter;
import com.example.asus.sqq1221.adapter.MyData;
import com.example.asus.sqq1221.presenter.MyPresenter;
import com.example.asus.sqq1221.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<T> extends AppCompatActivity implements MyView<T> {

    private XRecyclerView xrecy;
    private List<MyData.DataBean> Mdata=new ArrayList<>();
    private MyAdapter myAdapter;
    private MyPresenter myPresenter;
    private String mUrl="http://www.xieast.com/api/news/news.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //摄者属性及方向
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        xrecy.setLayoutManager(linearLayoutManager);

        //设置适配器
        myAdapter = new MyAdapter(this, Mdata);
        xrecy.setAdapter(myAdapter);

        //开始解析数据进行回传
        myPresenter = new MyPresenter(this);
        myPresenter.getRequest(mUrl,"0");
    }

    private void initView() {
        xrecy = (XRecyclerView) findViewById(R.id.xrecy);
    }



    //成功的方法
    @Override
    public void Success(Object data) {
        MyData data1 = (MyData) data;
        Mdata=data1.getData();
        myAdapter.setList(Mdata);
    }

    @Override
    public void error(Object error) {

    }
}
