package com.example.admin.quickmaths.utils;

import com.example.admin.quickmaths.model.Result;
import com.example.admin.quickmaths.model.Step;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

/**
 * Created by Jason on 11/4/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void updateNearbyPlaces(List<Result> nearbyPlacesList);
        void updateDirections(List<Step> stepList);
    }

    interface Presenter extends BasePresenter<View> {
        void getNearbyResults(String coordinates, GoogleMap googleMap);
        void getDirections(String destination);
    }
}


