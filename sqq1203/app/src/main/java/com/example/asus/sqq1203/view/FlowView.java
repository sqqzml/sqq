package com.example.asus.sqq1203.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FlowView extends LinearLayout {
    //初始化画笔
    private int mscreenwidth;


    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕宽度
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mscreenwidth = metrics.widthPixels;
        setOrientation(VERTICAL);
    }
    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    //初始化数据
    public void setData(ArrayList<String> data){
        //此时需要重新布局
       LinearLayout lin=getLin();
        for (int i = 0; i <data.size() ; i++) {
            Log.d("zzz",data.get(i));
            String s = data.get(i);
            int numlenth=0;
            int childCount = lin.getChildCount();
            for (int j = 0; j <childCount ; j++) {
                TextView tv = (TextView) lin.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int leftMargin = layoutParams.leftMargin;
                //重新测量textView的宽与高
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numlenth+=tv.getMeasuredWidth()+tv.getPaddingLeft()+tv.getPaddingRight()+leftMargin;
            }
            TextView text = getText();
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin=10;
            layoutParams.topMargin=5;
            text.setLayoutParams(layoutParams);
            text.measure(getMeasuredWidth(),getMeasuredHeight());
            text.setText(s);
            int dataLength = text.getMeasuredWidth();
            //将数据添加到TextView中
            if (mscreenwidth>=numlenth+dataLength){
                lin.addView(text);
            }
            else{
                //此时我们需要跳到下一行进行展示
               lin=getLin();
              lin.addView(text);
            }
        }
    }
    //删除的方法
    private void Remove(){
        //移除所有的视图
        removeAllViews();
    }
    //首先初始化LinearLayout
    private LinearLayout getLin(){
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        //添加布局
        this.addView(linearLayout);
        return linearLayout;
    }
    //初始化TextView
    private TextView getText(){
        TextView textView = new TextView(getContext());
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}
