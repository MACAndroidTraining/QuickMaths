package com.example.admin.quickmaths;


import com.example.admin.quickmaths.model.google.DirectionsResponse;
import com.example.admin.quickmaths.model.google.GooglePlacesResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GooglePlacesRemoteServiceHelper {

    static final String PLACES_API_KEY = "AIzaSyCWIiUADHL68okOfePQib_N7SBdNhH4ldo";
    private static final String DIRECTIONS_API_KEY = "AIzaSyDXG9C6R8tZAtYM6UWsrKIXnaiwNNsBxYk";
    private static final String BASE_URL = "https://maps.googleapis.com/";

    public static Retrofit create() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Observable<GooglePlacesResult> getNearbyResults(String coordinates, String storeName) {

        Retrofit retrofit = create();
        GooglePlaceRemoteService service = retrofit.create(GooglePlaceRemoteService.class);
        return service.getNearbyResults(PLACES_API_KEY, coordinates, 50000+"",
                storeName);
    }

    public static Observable<DirectionsResponse> getDirections(String origin, String destination, List<String> wayPoints) {
        StringBuilder sb = new StringBuilder();
        sb.append("optimize:true|");
        for(int i = 0; i < wayPoints.size(); i++) {

            if(i < wayPoints.size()-1)
                sb.append(wayPoints.get(i)).append("|");
            else
                sb.append(wayPoints.get(i));
        }


        Retrofit retrofit = create();
        GooglePlaceRemoteService service = retrofit.create(GooglePlaceRemoteService.class);
        return service.getDirections(origin, destination, DIRECTIONS_API_KEY, sb.toString());
    }

}
