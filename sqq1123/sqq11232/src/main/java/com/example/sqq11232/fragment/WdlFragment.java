package com.example.sqq11232.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sqq11232.R;

public class WdlFragment extends Fragment {
    private RadioButton sy;
    private RadioButton zr;
    private RadioButton wdl;
    private RadioGroup rg;
    private ViewPager vp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.wdl, null);
        initView(inflate);
        //初始化数据
        initData();
        return inflate;
    }

    private void initData() {
    }

    private void initView(View inflate) {
        sy = (RadioButton) inflate.findViewById(R.id.sy);
        zr = (RadioButton) inflate.findViewById(R.id.zr);
        wdl = (RadioButton) inflate.findViewById(R.id.wdl);
        rg = (RadioGroup) inflate.findViewById(R.id.rg);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
    }
}
