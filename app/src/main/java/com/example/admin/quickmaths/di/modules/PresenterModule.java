package com.example.admin.quickmaths.di.modules;


import com.example.admin.quickmaths.presenter.DirectionsPresenter;
import com.example.admin.quickmaths.presenter.GooglePlacesPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {


    @Provides
    GooglePlacesPresenter provideGooglePlacesPresenter() {
        return new GooglePlacesPresenter();
    }

    @Provides
    DirectionsPresenter provideDirectionsPresenter() { return  new DirectionsPresenter(); }

}
