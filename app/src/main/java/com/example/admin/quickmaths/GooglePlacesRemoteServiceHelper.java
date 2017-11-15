package com.example.admin.quickmaths;


import com.example.admin.quickmaths.model.DirectionsResponse;
import com.example.admin.quickmaths.model.GooglePlacesResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 11/4/2017.
 */

public class GooglePlacesRemoteServiceHelper {

    public static final String PLACES_API_KEY = "AIzaSyCWIiUADHL68okOfePQib_N7SBdNhH4ldo";
    public static final String DIRECTIONS_API_KEY = "AIzaSyDXG9C6R8tZAtYM6UWsrKIXnaiwNNsBxYk";
    private static final String BASE_URL = "https://maps.googleapis.com/";

    public static Retrofit create() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<GooglePlacesResult> getNearbyResults(String coordinates) {

        Retrofit retrofit = create();
        GooglePlaceRemoteService service = retrofit.create(GooglePlaceRemoteService.class);
        return service.getNearbyResults(PLACES_API_KEY, coordinates, 10000+"", "(walmart) OR (QuikTrip)");
    }

    public static Observable<DirectionsResponse> getDirections(String origin, String destination) {

        Retrofit retrofit = create();
        GooglePlaceRemoteService service = retrofit.create(GooglePlaceRemoteService.class);
        return service.getDirections(origin, destination, DIRECTIONS_API_KEY);
    }

}