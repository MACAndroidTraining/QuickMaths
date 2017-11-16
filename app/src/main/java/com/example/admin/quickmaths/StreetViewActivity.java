package com.example.admin.quickmaths;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class StreetViewActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        StreetViewPanoramaFragment streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager()
                .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }

    // TODO: 11/16/2017 Fix StreetView precision
    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        String destinationLocation = getIntent().getStringExtra("destinationCoordinates");
        String[] coordinates = destinationLocation.split(",");
        LatLng coordinatesOfCurrentLocation = new LatLng(Double.parseDouble(coordinates[0]),
                Double.parseDouble(coordinates[1]));
        streetViewPanorama.setPosition(coordinatesOfCurrentLocation, 200);
    }
}
