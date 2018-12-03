package com.example.sqq11232.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sqq11232.MainActivity;
import com.example.sqq11232.R;
import com.example.sqq11232.adapter.MyAdapter;

import java.util.ArrayList;

public class MyFragment extends Fragment {
    private RadioButton sy;
    private RadioButton zr;
    private RadioButton wdl;
    private RadioGroup rg;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private MyAdapter adapter;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.one, null);
        initData();
        initView(inflate);
        //初始化数据
        return inflate;
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new SyFragment());
        list.add(new ZrFragment());
        list.add(new WdlFragment());
    }

    private void initView(View inflate) {
        sy = (RadioButton) inflate.findViewById(R.id.sy);
        zr = (RadioButton) inflate.findViewById(R.id.zr);
        wdl = (RadioButton) inflate.findViewById(R.id.wdl);
        rg = (RadioGroup) inflate.findViewById(R.id.rg);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
        myAdapter = new MyAdapter(getChildFragmentManager(), list);
        vp.setAdapter(myAdapter);
        //vp设置监听事件
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
             if(i==0){
                 rg.check(R.id.sy);
             }
                if(i==1){
                    rg.check(R.id.zr);
                }
                if(i==2){
                    rg.check(R.id.wdl);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //为RadioGroup设置监听事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.sy){
                    vp.setCurrentItem(0);
                }
                if (checkedId==R.id.zr){
                    vp.setCurrentItem(1);
                }
                if (checkedId==R.id.wdl){
                    vp.setCurrentItem(2);
                }
            }
        });
    }



}
