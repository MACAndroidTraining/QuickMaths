package com.example.admin.quickmaths.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import com.example.admin.quickmaths.GooglePlacesRemoteServiceHelper;
import com.example.admin.quickmaths.StreetViewActivity;
import com.example.admin.quickmaths.model.google.DirectionsResponse;
import com.example.admin.quickmaths.model.google.Leg;
import com.example.admin.quickmaths.model.google.OverviewPolyline;
import com.example.admin.quickmaths.model.google.Route;
import com.example.admin.quickmaths.model.google.Step;
import com.example.admin.quickmaths.utils.MainActivityContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DirectionsPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private String currentLocation;
    private GoogleMap map;
    private List<Step> stepList = new ArrayList<>();
    private Context context;
    private int animationCounter = 0;
    private List<String> wayPoints;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getNearbyResults(String coordinates, GoogleMap googleMap, String anything) {
        currentLocation = coordinates;
        map = googleMap;

    }
    @Override
    public void getDirections(final String destination) {

        final List<LatLng> polyline = new ArrayList<>();
        final LatLng[] coordinatesOfCurrentLocation = {null};
        final OverviewPolyline[] overviewPolyline = new OverviewPolyline[1];

        //Previously was using destination as second argument
        GooglePlacesRemoteServiceHelper.getDirections(currentLocation, wayPoints.get(0), wayPoints)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DirectionsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DirectionsResponse directionsResponse) {

                        Route route = directionsResponse.getRoutes().get(0);
                        overviewPolyline[0] = route.getOverviewPolyline();
                        String[] coordinates = currentLocation.split(",");

                        for(Leg leg: route.getLegs())
                            stepList.addAll(leg.getSteps());


                        //Distinct marker for current location on the map
                        coordinatesOfCurrentLocation[0] = new LatLng(Double.parseDouble(coordinates[0]),
                                Double.parseDouble(coordinates[1]));

                        map.addMarker(new MarkerOptions().position(coordinatesOfCurrentLocation[0]).title("Current Location")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
                                .setTag(currentLocation);


                        //The tag enables us to identify which marker was clicked, so that we can launch streetview on the
                        //correct marker

                        for(String wayPoint: wayPoints) {
                            String[] wayPointCoordinates = wayPoint.split(",");
                            LatLng coordinate = new LatLng(Double.parseDouble(wayPointCoordinates[0])
                                    , Double.parseDouble(wayPointCoordinates[1]));
                            map.addMarker(new MarkerOptions().position(coordinate)).setTag(wayPoint);
                        }

                        polyline.addAll(PolyUtil.decode(overviewPolyline[0].getPoints()));


                        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker) {
                                Intent intent = new Intent(context, StreetViewActivity.class);
                                intent.putExtra("destinationCoordinates", (String) marker.getTag());
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                                return false;
                            }
                        });

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                        final GoogleMap.CancelableCallback cancelableCallback = new GoogleMap.CancelableCallback() {
                            @Override
                            public void onFinish() {
                                if(animationCounter < polyline.size()) {
                                    PolylineOptions polyLineSegment = new PolylineOptions();
                                    polyLineSegment.add(polyline.get(animationCounter));

                                    if(animationCounter < polyline.size()-1)
                                        polyLineSegment.add(polyline.get(animationCounter + 1));

                                    polyLineSegment.width(5).color(Color.BLUE);
                                    map.addPolyline(polyLineSegment);

                                    CameraPosition cameraPolylinePosition =
                                            new CameraPosition.Builder()
                                                    .target(polyline.get(animationCounter))
                                                    .tilt(animationCounter < polyline.size()-1? 90: 0)
                                                    .zoom(map.getCameraPosition().zoom)
                                                    .build();

                                    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPolylinePosition)
                                            , 10, this);
                                    animationCounter ++;
                                }
                            }

                            @Override
                            public void onCancel() {

                            }
                        };

                        //Initial camera position
                        CameraPosition cameraPosition =
                                new CameraPosition.Builder()
                                        .target(coordinatesOfCurrentLocation[0])
                                        .bearing(45)
                                        .tilt(90)
                                        .zoom(15)
                                        .build();

                        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), cancelableCallback);
                        view.updateDirections(stepList);
                    }
                });

    }

    public void setWayPoints(List<String> wayPoints) {
        this.wayPoints = wayPoints;
    }
}
