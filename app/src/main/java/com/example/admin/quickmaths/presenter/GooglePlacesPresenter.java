package com.example.admin.quickmaths.presenter;

import android.annotation.SuppressLint;

import com.example.admin.quickmaths.GooglePlacesRemoteServiceHelper;
import com.example.admin.quickmaths.model.google.GooglePlacesResult;
import com.example.admin.quickmaths.model.google.Location;
import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.utils.MainActivityContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class GooglePlacesPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private List<Result> resultList = new ArrayList<>();

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getNearbyResults(final String CurrentLocation, final GoogleMap googleMap, String storeName) {

        GooglePlacesRemoteServiceHelper.getNearbyResults(CurrentLocation, storeName)
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

                    @SuppressLint("NewApi")
                    @Override
                    public void onNext(List<Result> results) {

                        List<String> storesReturnedFromSearch = new ArrayList<>();
                        double currentLocationLat, currentLocationLong;
                        Map<String, List<Result>> storeSearch = new HashMap<>();
                        String[] coordinates = CurrentLocation.split(",");
                        currentLocationLat = Double.parseDouble(coordinates[0]);
                        currentLocationLong = Double.parseDouble(coordinates[1]);


                        //Adding the names of all stores in the search in one single array
                        for(Result result : results) {
                            if(storesReturnedFromSearch.contains(result.getName()))
                                continue;
                            else
                                storesReturnedFromSearch.add(result.getName());
                        }

                        //Initializing every single key with a corresponding Result array
                        for(String storeName:storesReturnedFromSearch) {
                            List<Result> array = new ArrayList<>();
                            storeSearch.put(storeName, array);
                        }

                        //Populating each list for each key in the map
                        for(Result result: results) {
                            List<Result> tempArray = new ArrayList<>();
                            List<Result> keyArray = storeSearch.get(result.getName());
                            tempArray.add(result);
                            tempArray.addAll(keyArray);
                            storeSearch.put(result.getName(), tempArray);
                        }

                        //Finding the closest store for each merchant
                        for(String key: storeSearch.keySet()) {
                            List<Result> stores = storeSearch.get(key);
                            LatLng closestStore = new LatLng(stores.get(0).getGeometry().getLocation().getLat(),
                                    stores.get(0).getGeometry().getLocation().getLng());

                            String closestStoreName = stores.get(0).getName();
                            Result closestResult = stores.get(0);

                            double storeShortestDistance = Math.sqrt((stores.get(0).getGeometry().getLocation().getLat() -
                                    currentLocationLat) + (stores.get(0).getGeometry().getLocation().getLng() -
                                    currentLocationLong));

                            for (Result result: stores) {
                                Location storeLocation = result.getGeometry().getLocation();
                                double currentStoreDistance = Math.sqrt(storeLocation.getLat() -
                                        currentLocationLat) + (storeLocation.getLng() -
                                        currentLocationLong);
                                if(currentStoreDistance < storeShortestDistance) {
                                    closestStore = new LatLng(storeLocation.getLat(),storeLocation.getLng());
                                    closestStoreName = result.getName();
                                    closestResult = result;
                                }
                            }

                            resultList.add(closestResult);
                            googleMap.addMarker(new MarkerOptions().position(closestStore)
                                    .title(closestStoreName)).showInfoWindow();
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(closestStore, 10));
                        }

                        //Distinct marker for current location on the map
                        LatLng currentLocation = new LatLng(currentLocationLat, currentLocationLong);
                        googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        view.updateNearbyPlaces(resultList);
                    }
                });
    }

    //This presenter is connected to the mainActivity. Since we don't retrieve directions on the mainactivity, the
    //getDirections method is not needed
    @Override
    public void getDirections(String destination) {

    }

}
