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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    ImageView imageView;
    TextView searchType;

    int pageCall = 1;
    int threadCheck = 0;
    boolean threadBool;
    RecycleViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    ApiActivityPresenter presenter = new ApiActivityPresenter();

    List<DisplayObject> newItemList = new ArrayList<>();

    View myView;

    String upc;

    boolean oncreatecalled = false;

    String itemImage = "";

    String stringSearchType;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        oncreatecalled = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        myView = inflater.inflate(R.layout.activity_api, container, false);
        init();
        Log.d(TAG, "onCreateView: " + newItemList.size());
        return myView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
        oncreatecalled = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        oncreatecalled = false;
    }

    private void init() {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_api);
//        ButterKnife.bind(this);

        upcTextView = myView.findViewById(R.id.tvUPC);
        rvItems = myView.findViewById(R.id.rvItems);
        imageView = myView.findViewById(R.id.ivItemImage);
        searchType = myView.findViewById(R.id.searchType);

        if(!itemImage.isEmpty()){
            Glide.with(getActivity())
                    .load( itemImage )
                    .into(this.imageView);
        }

        //set up dagger

//        String upc = getIntent().getStringExtra("query");

        layoutManager = new LinearLayoutManager(getActivity());
        recycleViewAdapter = new RecycleViewAdapter(getActivity(), newItemList, getActivity());
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);

        if(oncreatecalled) {
            threadBool = false;
            Log.d(TAG, "init: here");
            upc = getArguments().getString("query");
            presenter.attachView(this);
            if (upc.matches("[0-9]+") && upc.length() > 1) {
                Log.d(TAG, "init: numbers");
                presenter.makeCall(pageCall, upc);
                stringSearchType = "UPC: ";
            }else{
                Log.d(TAG, "init: text search");
                presenter.textSearch(upc);
                stringSearchType = "SEARCH: ";
            }
        }

        searchType.setText(stringSearchType);
        upcTextView.setText(upc);

//        newItemList.add(new DisplayObject("food", "Mac's", "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg", 2.00, 0, true));
//        newItemList = mergeSort(newItemList);
//        recycleViewAdapter.notifyDataSetChanged();
    }

    public void setSearchType(String s){
        stringSearchType = s;
        searchType.setText(stringSearchType);
    }

    public void setItemImage(String itemImageURL){
        this.itemImage = itemImageURL;
        Glide.with(getActivity())
                .load( itemImage )
                .into(this.imageView);
    }

    public void initRecyclerView(List<DisplayObject> itemList) {
        newItemList = itemList;

        layoutManager = new LinearLayoutManager(getActivity());
        recycleViewAdapter = new RecycleViewAdapter(getActivity(), newItemList, getActivity());
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);

        Log.d(TAG, "initRecyclerView: threadCheck: "+threadCheck);
        if(threadCheck == 4|| threadBool){
            Thread mergeThread = new Thread(){
                @Override
                public void run() {
                    super.run();
                    newItemList = presenter.mergeSort(newItemList);
                    threadBool = false;
                    initRecyclerView(newItemList);
                }
            };
            mergeThread.start();
        }
    }

    @Override
    public void domergesort(){
        threadBool = true;
    }
    @Override
    public void domergesortCheck(){
        threadCheck++;
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
