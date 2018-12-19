package com.example.asus.moni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkbox;
    private TextView title;
    private TextView price;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(linearLayoutManager);

    }

    private void initView() {
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        title = (TextView) findViewById(R.id.title);
        price = (TextView) findViewById(R.id.price);
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
