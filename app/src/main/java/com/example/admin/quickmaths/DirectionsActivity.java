package com.example.admin.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.quickmaths.di.component.DaggerPresenterComponent;
import com.example.admin.quickmaths.di.modules.LinearLayoutManagerModule;
import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.model.google.Step;
import com.example.admin.quickmaths.presenter.DirectionsPresenter;
import com.example.admin.quickmaths.utils.MainActivityContract;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class DirectionsActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject
    DirectionsPresenter presenter;
    @Inject
    LinearLayoutManager linearLayout;
    @Inject
    RecyclerView.ItemAnimator itemAnimator;
    @Inject
    BlankFragment fragment;
    @Inject
    Bundle bundle;

    RecyclerView recyclerView;
    GooglePlacesAdapter adapterForDirections;

    android.support.v4.app.FragmentManager manager;
    android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        recyclerView = findViewById(R.id.directionsRecyclerView);
        DaggerPresenterComponent.builder()
                .linearLayoutManagerModule(new LinearLayoutManagerModule(this))
                .build().inject(this);

        List<String> wayPoints = getIntent().getStringArrayListExtra("wayPoints");
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.directionsFragment, fragment, "directionsFragment").commit();
        presenter.attachView(this);
        presenter.setContext(getApplicationContext());
        fragment.setPresenter(presenter);
        fragment.setWayPoints(wayPoints);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateNearbyPlaces(List<Result> nearbyPlacesList, Map<String, Double> map) {

    }

    @Override
    public void updateDirections(List<Step> stepList) {
        adapterForDirections = new GooglePlacesAdapter(stepList,null);
        recyclerView.setAdapter(adapterForDirections);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setItemAnimator(itemAnimator);
    }
}

