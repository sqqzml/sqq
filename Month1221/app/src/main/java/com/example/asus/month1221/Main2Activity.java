package com.example.asus.month1221;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.month1221.adapter.MyAdapter;
import com.example.asus.month1221.adapter.MyBaseAdapter;
import com.example.asus.month1221.bean.MyData;
import com.example.asus.month1221.bean.MyData2;
import com.example.asus.month1221.presenter.MyPresenter;
import com.example.asus.month1221.presenter.MyPresenter2;
import com.example.asus.month1221.utils.OkHttpUtils;
import com.example.asus.month1221.utils.view.MyView2;
import com.example.asus.month1221.utils.view.Mytitle;
import com.example.asus.month1221.view.MyView;
import com.google.gson.Gson;
import com.yzq.zxinglibrary.encode.CodeCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Main2Activity<T> extends AppCompatActivity implements MyView<T>,MyView2<T>,View.OnClickListener {

    private Mytitle mytitle;
    private RecyclerView recycler1;
    private RecyclerView recycler2;
    private String Murl="http://www.zhaoapi.cn/product/getCatagory";
    private List<MyData.DataBean> mdata=new ArrayList<>();
    private MyPresenter myPresenter;
    private MyAdapter myAdapter;
    private List<MyData2.DataBean> data2=new ArrayList<>();
    private MyBaseAdapter myBaseAdapter;
    private MyPresenter2 myPresenter2;
    private String keywords="手机";
    private String page="1";
    private String MuRL2="http://www.zhaoapi.cn/product/searchProducts";
    private boolean str=true;

    //通过Handler发送消息
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String   S = (String) msg.obj;
            Gson gson = new Gson();
            MyData2 myData2 = gson.fromJson(S, MyData2.class);

            myBaseAdapter.setmList(myData2.getData());



        }
    };
    private MyPresenter2 myPresenter21;
    private ImageView img2;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

      GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        recycler1.setLayoutManager(gridLayoutManager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler2.setLayoutManager(layoutManager);

        myBaseAdapter = new MyBaseAdapter(this, data2);
        recycler2.setAdapter(myBaseAdapter);

        //设置适配器
        myAdapter = new MyAdapter(this, mdata);
        recycler1.setAdapter(myAdapter);

        recycler2.setAdapter(myAdapter);



        myPresenter = new MyPresenter(this);
        myPresenter.getRequestData(Murl);

        myPresenter21 = new MyPresenter2(this);
        myPresenter21.getRequestData2(MuRL2,keywords,page);
  //开始解析数据
       /* GsonData();*/



    }

   private void GsonData() {
        OkHttpUtils.getInstance().postAsync(MuRL2, keywords, page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                mHandler.sendMessage(mHandler.obtainMessage(0,string));

            }
        });
    }

    private void initView() {
        /*mytitle = (Mytitle) findViewById(R.id.mytitle);*/
        recycler1 = (RecyclerView) findViewById(R.id.recycler1);
        recycler2 = (RecyclerView) findViewById(R.id.recycler2);
        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(this);
        img = findViewById(R.id.img);
        img.setOnClickListener(this);
    /*    Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        {
//生成二维码需要用到类是CodeCreator
            Bitmap bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
            Image.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }*/
    }



    @Override
    public void success(T data) {
       MyData data1 = (MyData) data;
        mdata.addAll(data1.getData());
         myAdapter.setMdata(mdata);



    }


    @Override
    public void Success2(T data) {
        MyData2 data3 = (MyData2) data;
        data2.addAll(data3.getData());
        myBaseAdapter.setmList(data2);
    }

    @Override
    public void onClick(View v) {
      Toast.makeText(Main2Activity.this,"hahha",Toast.LENGTH_SHORT).show();
   /*if (false){
      str=true;
       GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
       recycler2.setLayoutManager(gridLayoutManager);
       myAdapter = new MyAdapter(this, mdata);
       recycler2.setAdapter(myBaseAdapter);
       myPresenter = new MyPresenter(this);
       myPresenter.getRequestData(Murl);

   }
   else{
      str=false;
       LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
       recycler2.setLayoutManager(layoutManager);
       myAdapter = new MyAdapter(this, mdata);
       recycler2.setAdapter(myBaseAdapter);
       myPresenter = new MyPresenter(this);
       myPresenter.getRequestData(Murl);
   }*/


    }
}
