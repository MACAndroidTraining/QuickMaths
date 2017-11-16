package com.example.admin.quickmaths;


import com.example.admin.quickmaths.model.google.DirectionsResponse;
import com.example.admin.quickmaths.model.google.GooglePlacesResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GooglePlaceRemoteService {

    @GET("maps/api/place/nearbysearch/json")
    Observable<GooglePlacesResult> getNearbyResults(@Query("key") String apiKey, @Query("location") String coordinates,
                                                    @Query("radius") String radius, @Query("keyword") String placeName);


    @GET("maps/api/directions/json")
    Observable<DirectionsResponse> getDirections(@Query("origin") String origin,
                                                 @Query("destination") String destination,
                                                 @Query("key") String key, @Query("waypoints") String wayPoints);

}

