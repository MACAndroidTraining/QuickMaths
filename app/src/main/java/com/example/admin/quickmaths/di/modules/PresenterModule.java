package com.example.admin.quickmaths.di.modules;


import com.example.admin.quickmaths.presenter.GooglePlacesPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jason on 11/4/2017.
 */

@Module
public class PresenterModule {


    @Provides
    GooglePlacesPresenter provideGooglePlacesPresenter() {
        return new GooglePlacesPresenter();
    }

}
