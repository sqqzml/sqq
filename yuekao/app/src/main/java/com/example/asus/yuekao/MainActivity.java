package com.example.asus.yuekao;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.format.DateFormat;
import android.view.View;

import com.example.asus.yuekao.adapter.MyAdapter;
import com.example.asus.yuekao.adapter.bean.MyData;
import com.example.asus.yuekao.adapter.presenter.MyPresenter;
import com.example.asus.yuekao.adapter.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView,XRecyclerView.LoadingListener{

    private XRecyclerView xrecy;
    private List<MyData.DataBean> Mdata=new ArrayList<>();
    private MyAdapter myAdapter;
    private MyPresenter myPresenter;
    private String mUrl="http://www.xieast.com/api/news/news.php";
    private int index=1;
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
        myPresenter.getRequest(mUrl,index);




    }

    private void initView() {
        xrecy = (XRecyclerView) findViewById(R.id.xrecy);
        xrecy.setLoadingListener(this);
        xrecy.setLoadingMoreEnabled(true);
        xrecy.setPullRefreshEnabled(true);
    }



    //成功的方法
    @Override
    public void Success(Object data) {
         MyData data1 = (MyData) data;
         Mdata.addAll(data1.getData());
         myAdapter.setList(Mdata);
    }

    @Override
    public void error(Object error) {

    }

    @Override
    public void onRefresh() {

        index=1;
        Mdata.clear();
        myPresenter.getRequest(mUrl,index);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                xrecy.refreshComplete();
            }
        },2000);
    }

    @Override
    public void onLoadMore() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                index++;
                myPresenter.getRequest(mUrl,index);
                xrecy.refreshComplete();
            }
        },2000);

    }


}
