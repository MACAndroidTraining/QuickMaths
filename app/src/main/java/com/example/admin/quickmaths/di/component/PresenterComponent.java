package com.example.admin.quickmaths.di.component;

import com.example.admin.quickmaths.DirectionsActivity;
import com.example.admin.quickmaths.di.modules.BlankFragmentModule;
import com.example.admin.quickmaths.di.modules.BundleModule;
import com.example.admin.quickmaths.di.modules.ItemAnimatorModule;
import com.example.admin.quickmaths.di.modules.LinearLayoutManagerModule;
import com.example.admin.quickmaths.di.modules.PresenterModule;
import com.example.admin.quickmaths.view.placesActivity.GooglePlacesActivity;

import dagger.Component;

@Component(modules = {PresenterModule.class, LinearLayoutManagerModule.class
        ,BlankFragmentModule.class, ItemAnimatorModule.class, BundleModule.class})

public interface PresenterComponent {

    void inject(GooglePlacesActivity mainActivity);
    void inject(DirectionsActivity directionsActivity);

}
