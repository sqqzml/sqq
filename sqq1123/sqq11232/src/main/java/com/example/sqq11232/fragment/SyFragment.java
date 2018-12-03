package com.example.sqq11232.fragment;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pulltolibrary.PullToRefreshBase;
import com.example.pulltolibrary.PullToRefreshListView;
import com.example.sqq11232.MainActivity;
import com.example.sqq11232.R;
import com.example.sqq11232.Utils.Utils;
import com.example.sqq11232.adapter.MyBaseAdapter;
import com.example.sqq11232.adapter.NetWorks;
import com.example.sqq11232.bean.MyData;
import com.example.sqq11232.dao.MyDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SyFragment extends Fragment {
    private RadioButton sy;
    private RadioButton zr;
    private RadioButton wdl;
    private RadioGroup rg;
    private ViewPager vp;
    private PullToRefreshListView pull_to_RefreshListView;
    private List<MyData.DataBean> data=new ArrayList<>();
    private int start=0;
    private MyBaseAdapter myBaseAdapter;
    private String mUrl="http://www.xieast.com/api/news/news.php?";
    private MyDao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.sy, null);
        initView(inflate);
        dao = new MyDao(getActivity());

        //判断是否有网络
       if (NetWorks.getNetwork(getActivity())){
           Toast.makeText(getActivity(),"有网，你玩吧",Toast.LENGTH_LONG).show();
           new Async().execute(mUrl+start);
       }
       else {
           Toast.makeText(getActivity(),"不好意思，现在没有网",Toast.LENGTH_LONG).show();
           //添加到数据库中
           String s = dao.select();
           Gson gson = new Gson();
           MyData myData = gson.fromJson(s, MyData.class);
           data.addAll(myData.getData());
           //刷新适配器
           myBaseAdapter.notifyDataSetChanged();
       }
        myBaseAdapter = new MyBaseAdapter(getActivity(), data);
        //设置适配器
        pull_to_RefreshListView.setAdapter(myBaseAdapter);
        //异步处理进行解析数据
        //设置上下拉刷新的监听事件
        setListener();
        return inflate;
    }



    private void initView(View inflate) {
        pull_to_RefreshListView = (PullToRefreshListView) inflate.findViewById(R.id.pull_to_RefreshListView);
       //设置可以进行上下拉刷新
        pull_to_RefreshListView.setMode(PullToRefreshListView.Mode.BOTH);
    }
    class Async extends AsyncTask<String,Void,List<MyData.DataBean>>{

        @Override
        protected List<MyData.DataBean> doInBackground(String... strings) {
            try {
                String str = Utils.getStr(strings[0]);
                Gson gson = new Gson();
                MyData myData = gson.fromJson(str, MyData.class);
                String s = myData.getMsg();
                ContentValues contentValues = new ContentValues();
                contentValues.put("title",s);
                dao.insert(contentValues+"");
                if (s!=null){
                return myData.getData();
                }
                else{
                    Toast.makeText(getActivity(),"对不起已经没有更多数据了",Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        //解析完成之后进行处理
        @Override
        protected void onPostExecute(List<MyData.DataBean> dataBeans) {
            super.onPostExecute(dataBeans);
            data.addAll(dataBeans);
            myBaseAdapter.notifyDataSetChanged();
        }

    }
    //设置监听事件
    public void setListener(){
        pull_to_RefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //设置下拉加载刚铎
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                start++;
                new Async().execute(mUrl+start);
                //设置停止刷新的操作
                pull_to_RefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pull_to_RefreshListView.onRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //首先清空数据
                start=0;
                data.clear();
                new Async().execute(mUrl+start);
                //设置停止刷新的操作
                pull_to_RefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pull_to_RefreshListView.onRefreshComplete();
                    }
                },1000);
            }
        });
    }

}
