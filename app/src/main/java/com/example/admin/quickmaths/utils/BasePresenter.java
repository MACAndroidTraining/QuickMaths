package com.example.admin.quickmaths.utils;

/**
 * Created by Jason on 11/4/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
