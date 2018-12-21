package com.example.asus.month1221.presenter;

import com.example.asus.month1221.callback.MyCallBack;
import com.example.asus.month1221.callback.MyModel;
import com.example.asus.month1221.callback.MyModel2;
import com.example.asus.month1221.utils.view.MyView2;
import com.example.asus.month1221.view.MyView;

public class MyPresenter2 implements Presenter2 {

    private MyView2 myView2;
    private  MyModel2 myModel2;

    public MyPresenter2(MyView2 myView2) {
        this.myView2 = myView2;
        myModel2 = new MyModel2();
    }



    //防止内存泄漏
    private void onDetatch(){
        if (myModel2!=null){
            myModel2=null;
        }
        if (myView2!=null){
           myView2=null;
        }
    }


    @Override
    public void getRequestData2(String mUrl, String keywords, String page) {
        myModel2.request(mUrl, keywords, page, new MyCallBack() {
            @Override
            public void success(Object data) {
                myView2.Success2(data);
            }
        });
    }
}
