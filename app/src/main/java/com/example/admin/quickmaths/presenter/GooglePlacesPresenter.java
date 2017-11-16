package com.example.admin.quickmaths.presenter;

import android.graphics.Color;
import android.util.Log;

import com.example.admin.quickmaths.GooglePlacesRemoteServiceHelper;
import com.example.admin.quickmaths.model.google.DirectionsResponse;
import com.example.admin.quickmaths.model.google.EndLocation;
import com.example.admin.quickmaths.model.google.GooglePlacesResult;
import com.example.admin.quickmaths.model.google.Leg;
import com.example.admin.quickmaths.model.google.Location;
import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.model.google.Route;
import com.example.admin.quickmaths.model.google.StartLocation;
import com.example.admin.quickmaths.model.google.Step;
import com.example.admin.quickmaths.utils.MainActivityContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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
    List<Step> stepList = new ArrayList<>();
    String currentLocation;
    GoogleMap map;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getNearbyResults(final String CurrentLocation, final GoogleMap googleMap) {

        currentLocation = CurrentLocation;
        map = googleMap;

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
                        String[] coordinates = CurrentLocation.split(",");
                        //Distinct marker for current location on the map
                        LatLng currentLocation = new LatLng(Double.parseDouble(coordinates[0]),
                                Double.parseDouble(coordinates[1]));
                        googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

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
    public void getDirections(String destination) {
        GooglePlacesRemoteServiceHelper.getDirections(currentLocation, destination)
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
                        stepList.addAll(leg.getSteps());
                        List<LatLng> polyline = new ArrayList<>();
                        for (Step step: stepList) {
                            StartLocation startLocation = step.getStartLocation();
                            EndLocation endLocation = step.getEndLocation();
                            polyline.add(new LatLng(startLocation.getLat(), startLocation.getLng()));
                            polyline.add(new LatLng(endLocation.getLat(), endLocation.getLng()));
                        }

                        PolylineOptions polylineOptions = new PolylineOptions();
                        for (LatLng latLng: polyline) {
                            polylineOptions.add(latLng);
                        }
                        polylineOptions.width(5).color(Color.BLUE);
                        map.addPolyline(polylineOptions);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        view.updateDirections(stepList);
                    }
                });
    }

}
