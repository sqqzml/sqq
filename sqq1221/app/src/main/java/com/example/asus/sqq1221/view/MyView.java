package com.example.asus.sqq1221.view;

public interface MyView<T> {
    void Success(T data) ;
    void error(T error);
}
