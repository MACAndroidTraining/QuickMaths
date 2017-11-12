package com.example.admin.quickmaths;


import com.example.admin.quickmaths.model.DirectionsResponse;
import com.example.admin.quickmaths.model.GooglePlacesResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jason on 11/4/2017.
 */

public interface GooglePlaceRemoteService {

    @GET("maps/api/place/nearbysearch/json")
    Observable<GooglePlacesResult> getNearbyResults(@Query("key") String apiKey, @Query("location") String coordinates,
                                                    @Query("radius") String radius, @Query("keyword") String placeName);

    // TODO: 11/6/2017 Add waypoints

    @GET("maps/api/directions/json")
    Observable<DirectionsResponse> getDirections(@Query("origin") String origin,
                                                 @Query("destination") String destination,
                                                 @Query("key") String key);
}

