package com.example.admin.quickmaths.view.apiActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends Fragment implements ApiActivityContract.View{

    private static final String TAG = "ApiActivity";

//    @BindView(R.id.tvUPC)
    TextView upcTextView;
//    @BindView(R.id.rvItems)
    RecyclerView rvItems;

    int pageCall = 1;
    int threadCheck = 0;
    RecycleViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    ApiActivityPresenter presenter = new ApiActivityPresenter();

    List<DisplayObject> newItemList = new ArrayList<>();

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_api, container, false);
        init();
        return myView;
    }

    private void init() {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_api);
//        ButterKnife.bind(this);

        upcTextView = myView.findViewById(R.id.tvUPC);
        rvItems = myView.findViewById(R.id.rvItems);

        presenter.attachView(this);
        //set up dagger

//        String upc = getIntent().getStringExtra("query");
        String upc = getArguments().getString("query");
        upcTextView.setText("Results for: " + upc);

        presenter.makeCall(pageCall, upc);

    }

    public void initRecyclerView(List<DisplayObject> itemList) {
        newItemList = itemList;
        threadCheck++;

        layoutManager = new LinearLayoutManager(getActivity());
        recycleViewAdapter = new RecycleViewAdapter(getActivity(), newItemList, getActivity());
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);

        Log.d(TAG, "initRecyclerView: threadCheck: "+threadCheck);
        if(threadCheck == 4){
            newItemList = presenter.mergeSort(newItemList);
            initRecyclerView(newItemList);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError(String error) {

    }

//    @Override
//    public void onItemClicked(DisplayObject displayObject) {
//        Log.d(TAG, "onItemClicked: ");
//    }
}
