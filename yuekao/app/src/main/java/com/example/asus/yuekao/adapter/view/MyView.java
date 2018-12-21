package com.example.asus.yuekao.adapter.view;

public interface MyView<T> {
    void Success(T data) ;
    void error(T error);
}
