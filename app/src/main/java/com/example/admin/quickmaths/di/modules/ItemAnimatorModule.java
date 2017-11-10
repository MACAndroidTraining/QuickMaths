package com.example.admin.quickmaths.di.modules;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jason on 11/6/2017.
 */

@Module
public class ItemAnimatorModule {

    @Provides
    RecyclerView.ItemAnimator provideItemAnimator() {
        return new DefaultItemAnimator();
    }
}

