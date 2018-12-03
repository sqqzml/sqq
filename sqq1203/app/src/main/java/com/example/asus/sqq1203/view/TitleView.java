package com.example.asus.sqq1203.view;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.sqq1203.R;

public class TitleView extends LinearLayout{


    private final EditText ss;
    private final TextView tianjia;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tite_view,this);
        ss = findViewById(R.id.sousuo);
        tianjia = findViewById(R.id.add);
    }

    //重写构造方法

    public String getSs() {
        return ss.getText().toString().trim();
    }

    public TextView getTianjia() {
        return tianjia;
    }
}
