package com.example.admin.quickmaths.di.modules;


import com.example.admin.quickmaths.BlankFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jason on 11/6/2017.
 */

@Module
public class BlankFragmentModule {

    @Provides
    BlankFragment provideBlankFragment() {
        return new BlankFragment();
    }
}
