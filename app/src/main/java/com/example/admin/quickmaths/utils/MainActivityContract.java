package com.example.admin.quickmaths.utils;

import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.model.google.Step;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 11/4/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void updateNearbyPlaces(List<Result> nearbyPlacesList, Map<String, Double> map);
        void updateDirections(List<Step> stepList);
    }

    interface Presenter extends BasePresenter<View> {
        void getNearbyResults(String coordinates, GoogleMap googleMap, List<String> storeNames);
        void getDirections(String destination);
    }
}


