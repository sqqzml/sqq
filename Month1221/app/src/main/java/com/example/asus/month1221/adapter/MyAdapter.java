package com.example.asus.month1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.month1221.R;
import com.example.asus.month1221.bean.MyData;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener{
    private Context context;
    private List<MyData.DataBean> mdata;

    public MyAdapter(Context context, List<MyData.DataBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    public void setMdata(List<MyData.DataBean> mdata) {
        this.mdata = mdata;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Glide.with(context).load(mdata.get(i).getIcon()).into(myViewHolder.img);
       myViewHolder.title.setText(mdata.get(i).getName());
       myViewHolder.itemView.setOnClickListener(this);
        myViewHolder.itemView.getTag();
       //通过图片吐司地址
        myViewHolder.img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
              /*  Toast.makeText(context,mdata.get(0).getIcon().toString(),Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    @Override
    public void onClick(View v) {
        setOnClick.onClick(v,(int)v.getTag());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private  ImageView img;
        private  TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.img);
             title = itemView.findViewById(R.id.title);
        }
    }
    //通过接口实现点击事件
    public interface setOnClick{
        void onClick(View v,int postion);
    }
    private setOnClick setOnClick;

    public void setSetOnClick(MyAdapter.setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }
}
