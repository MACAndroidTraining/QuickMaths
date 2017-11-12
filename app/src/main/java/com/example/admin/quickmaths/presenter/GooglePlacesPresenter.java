package com.example.admin.quickmaths.presenter;

import android.util.Log;

import com.example.admin.quickmaths.GooglePlacesRemoteServiceHelper;
import com.example.admin.quickmaths.model.DirectionsResponse;
import com.example.admin.quickmaths.model.GooglePlacesResult;
import com.example.admin.quickmaths.model.Leg;
import com.example.admin.quickmaths.model.Location;
import com.example.admin.quickmaths.model.Result;
import com.example.admin.quickmaths.model.Route;
import com.example.admin.quickmaths.model.Step;
import com.example.admin.quickmaths.utils.MainActivityContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by Jason on 11/4/2017.
 */

public class GooglePlacesPresenter implements MainActivityContract.Presenter, Serializable {

    MainActivityContract.View view;
    List<Result> resultList = new ArrayList<>();

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getNearbyResults(final String CurrentLocation, final GoogleMap googleMap) {

        GooglePlacesRemoteServiceHelper.getNearbyResults(CurrentLocation)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<GooglePlacesResult, List<Result>>() {
                    @Override
                    public List<Result> apply(GooglePlacesResult googlePlacesResult) throws Exception {
                        List<Result> aList = new ArrayList<>();
                        aList.addAll(googlePlacesResult.getResults());
                        return aList;
                    }
                })
                .subscribe(new Observer<List<Result>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Result> results) {

                        resultList.addAll(results);

                        for(Result result: results) {
                            Location location = result.getGeometry().getLocation();
                            LatLng placesCoordinates = new LatLng(location.getLat(), location.getLng());
                            googleMap.addMarker(new MarkerOptions().position(placesCoordinates).title(result.getName()));
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placesCoordinates, 10));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                        view.updateNearbyPlaces(resultList);
                    }
                });
    }

    @Override
    public void getDirections(String origin, String destination) {
        GooglePlacesRemoteServiceHelper.getDirections(origin, destination)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DirectionsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DirectionsResponse directionsResponse) {
                        Route route = directionsResponse.getRoutes().get(0);
                        Leg leg = route.getLegs().get(0);
                        List<Step> stepList = leg.getSteps();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}