package com.example.admin.quickmaths.view.placesActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.quickmaths.BlankFragment;
import com.example.admin.quickmaths.DirectionsActivity;
import com.example.admin.quickmaths.GooglePlacesAdapter;
import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.di.component.DaggerPresenterComponent;
import com.example.admin.quickmaths.di.modules.LinearLayoutManagerModule;
import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.model.google.Step;
import com.example.admin.quickmaths.presenter.GooglePlacesPresenter;
import com.example.admin.quickmaths.utils.MainActivityContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GooglePlacesActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject
    GooglePlacesPresenter presenter;
    @Inject
    LinearLayoutManager linearLayout;
    @Inject
    RecyclerView.ItemAnimator itemAnimator;
    @Inject
    BlankFragment fragment;
    @Inject
    Bundle bundle;

    List<Result> resultList;
    List<Step> stepList;
    RecyclerView recyclerView;
    GooglePlacesAdapter adapterForNearbyPlaces;
    GooglePlacesAdapter adapterForDirections;


    android.support.v4.app.FragmentManager manager;
    android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_places);

        recyclerView = findViewById(R.id.recyclerView);
        resultList = new ArrayList<>();
        stepList = new ArrayList<>();
        DaggerPresenterComponent.builder()
                .linearLayoutManagerModule(new LinearLayoutManagerModule(this))
                .build().inject(this);
        String storeName = getIntent().getStringExtra("storeName");
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.flFragment, fragment, "fragment").commit();
        presenter.attachView(this);
        fragment.setStoreName(storeName);
        fragment.setPresenter(presenter);


    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateNearbyPlaces(List<Result> nearbyPlacesList) {
        resultList.addAll(nearbyPlacesList);
        adapterForNearbyPlaces = new GooglePlacesAdapter(resultList);
        recyclerView.setAdapter(adapterForNearbyPlaces);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setItemAnimator(itemAnimator);

    }

    //I chose to use setAdapter instead of swapAdapter because swapAdapter between two lists works only if the lists
    //are of the same size
    @Override
    public void updateDirections(List<Step> stepList) {
        this.stepList.addAll(stepList);
        adapterForDirections = new GooglePlacesAdapter(stepList, null);
        recyclerView.setAdapter(adapterForDirections);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setItemAnimator(itemAnimator);
    }


    public void sendSelectedLocations(View view) {
        ArrayList<String> wayPoints = (ArrayList<String>) adapterForNearbyPlaces.getWayPoints();
        Intent intent = new Intent(this, DirectionsActivity.class);
        intent.putStringArrayListExtra("wayPoints", wayPoints);
        startActivity(intent);
    }

}

