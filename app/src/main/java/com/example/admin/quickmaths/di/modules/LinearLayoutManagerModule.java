package com.example.admin.quickmaths.di.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jason on 11/6/2017.
 */

@Module
public class LinearLayoutManagerModule {

    Context context;

    public LinearLayoutManagerModule(Context context) {
        this.context = context;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }
}

