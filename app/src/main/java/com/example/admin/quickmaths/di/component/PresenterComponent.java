package com.example.admin.quickmaths.di.component;

import android.support.v7.widget.LinearLayoutManager;

import com.example.admin.quickmaths.MainActivity;
import com.example.admin.quickmaths.di.modules.BlankFragmentModule;
import com.example.admin.quickmaths.di.modules.BundleModule;
import com.example.admin.quickmaths.di.modules.ItemAnimatorModule;
import com.example.admin.quickmaths.di.modules.LinearLayoutManagerModule;
import com.example.admin.quickmaths.di.modules.PresenterModule;

import dagger.Component;

/**
 * Created by Jason on 11/4/2017.
 */

@Component(modules = {PresenterModule.class, LinearLayoutManagerModule.class
        ,BlankFragmentModule.class, ItemAnimatorModule.class, BundleModule.class})

public interface PresenterComponent {

    void inject(MainActivity mainActivity);

}
