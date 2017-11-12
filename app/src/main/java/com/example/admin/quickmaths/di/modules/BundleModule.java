package com.example.admin.quickmaths.di.modules;

import android.os.Bundle;

import dagger.Module;
import dagger.Provides;

@Module
public class BundleModule {

    @Provides
    Bundle provideBundle() {
        return new Bundle();
    }
}