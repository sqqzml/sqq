package com.example.asus.month1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.month1221.R;
import com.example.asus.month1221.bean.MyData2;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyViewHolder1> {
    private Context context;
    private List<MyData2.DataBean> mList=new ArrayList<>();

    public MyBaseAdapter(Context context, List<MyData2.DataBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    public void setmList(List<MyData2.DataBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, null);
        MyViewHolder1 holder1 = new MyViewHolder1(view);
        return holder1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 myViewHolder, int i) {
         String s = mList.get(i).getImages();
        Glide.with(context).load(s).into(myViewHolder.img);
        myViewHolder.title1.setText(mList.get(i).getTitle());
        myViewHolder.price.setText(mList.get(i).getBargainPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder{

        private  ImageView img;
        private  TextView title1;
        private  TextView price;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.img);
             title1 = itemView.findViewById(R.id.title1);
             price=itemView.findViewById(R.id.price);
        }
    }


}
