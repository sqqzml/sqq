package com.example.asus.month1221.utils.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.month1221.R;

public class Mytitle extends LinearLayout implements View.OnClickListener {

    private final ImageView img;

    public Mytitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.mytitle, this);
        img = view.findViewById(R.id.img);

    }

    @Override
    public void onClick(View v) {
      img.setOnClickListener(this);
        Toast.makeText(getContext(),"哈哈哈",Toast.LENGTH_SHORT).show();
    }

    public interface setOnclick{
        void onClick(int postion);
    }
    private setOnclick setOnclick;

    public void setSetOnclick(Mytitle.setOnclick setOnclick) {
        this.setOnclick = setOnclick;
    }
}
