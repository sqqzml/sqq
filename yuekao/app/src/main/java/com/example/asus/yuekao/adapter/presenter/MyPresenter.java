package com.example.asus.yuekao.adapter.presenter;

import com.example.asus.yuekao.adapter.callBack.MyCallBack;
import com.example.asus.yuekao.adapter.model.MyModel;
import com.example.asus.yuekao.adapter.view.MyView;

public class MyPresenter implements Presenter {
    private MyView myView;
    private MyModel myModel;

    public MyPresenter(MyView myView) {
        this.myView=myView;
         myModel = new MyModel();
    }

    @Override
    public void getRequest(String mUrl, int page) {
        myModel.requestData(mUrl, page, new MyCallBack() {
            @Override
            public void Success(Object data) {
                myView.Success(data);
            }
        });
    }
    //防止内存泄漏
    public void OnDedatch(){
        if (myView!=null){
            myView=null;
        }
        if (myModel!=null){
            myModel=null;
        }
    }
}
