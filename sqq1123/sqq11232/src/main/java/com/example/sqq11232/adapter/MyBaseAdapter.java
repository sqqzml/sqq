package com.example.sqq11232.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqq11232.R;
import com.example.sqq11232.bean.MyData;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<MyData.DataBean> list;
    private ImageLoader imageLoader=ImageLoader.getInstance();
    private DisplayImageOptions displayImageOptions;
    private final int Type_1=0;
    private final int Type_2=1;

    public MyBaseAdapter(Context context, List<MyData.DataBean> list) {
        this.context = context;
        this.list = list;
        displayImageOptions= new DisplayImageOptions.Builder()
                //加载成圆角图片
                .displayer(new RoundedBitmapDisplayer(100))// 图片圆角显示
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisk(true)// default  设置下载的图片是否缓存在SD卡中
                .build();
    }

    public void setList(List<MyData.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return Type_1;
        }
        else{
            return Type_2;
        }

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyData.DataBean bean = list.get(position);
        ViewHolder holder;
        ViewHolder2 holder2;
        int type = getItemViewType(position);
        switch (type){
            case Type_1:
                if (convertView==null){
                    convertView= View.inflate(context, R.layout.list_item, null);
                    holder= new ViewHolder();
                    holder.t_title=convertView.findViewById(R.id.title);
                    holder.img=convertView.findViewById(R.id.image);
                    convertView.setTag(holder);
                }
                else{
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.t_title.setText(list.get(position).getTitle());
                imageLoader.displayImage(bean.getThumbnail_pic_s(),holder.img,displayImageOptions);
                break;
            case Type_2:
                if (convertView==null){
                    convertView= View.inflate(context, R.layout.list_two, null);
                    holder2= new ViewHolder2();
                    holder2.t_title2=convertView.findViewById(R.id.title2);
                    holder2.img2=convertView.findViewById(R.id.image1);
                    convertView.setTag(holder2);
                }
                else{
                    holder2 = (ViewHolder2) convertView.getTag();
                }
             holder2.t_title2.setText(list.get(position).getTitle());
                imageLoader.displayImage(bean.getThumbnail_pic_s(),holder2.img2,displayImageOptions);
                break;
        }

        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView t_title;
    }
    class ViewHolder2{
        ImageView img2;
        TextView t_title2;
    }
}
