package com.example.asus.month1221.presenter;

import com.example.asus.month1221.callback.Model;
import com.example.asus.month1221.callback.MyCallBack;
import com.example.asus.month1221.callback.MyModel;
import com.example.asus.month1221.callback.MyModel2;
import com.example.asus.month1221.view.MyView;

public class MyPresenter implements Presenter {
    private MyModel myModel;
    private MyView myView;
    private MyModel2 myModel2;

    public MyPresenter( MyView myView) {
        this.myView = myView;
       myModel = new MyModel();
    }

    @Override
    public void getRequestData(String mUrl) {
        myModel.request(mUrl, new MyCallBack() {
            @Override
            public void success(Object data) {
                myView.success(data);

            }
        });
    }

  /*  public void getRequestData2(String mUrl, String keywords, String page) {
        myModel.request(mUrl, keywords, page, new MyCallBack() {
            @Override
            public void success(Object data) {
                myView.success(data);
            }
        });
    }*/
    //防止内存泄漏
    private void onDetatch(){
        if (myModel!=null){
            myModel=null;
        }
        if (myView!=null){
           myView=null;
        }
    }
}
