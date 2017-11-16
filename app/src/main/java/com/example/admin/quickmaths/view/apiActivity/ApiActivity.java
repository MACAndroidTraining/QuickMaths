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
//        newItemList.add(new DisplayObject("food", "Mac's", "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg", 2.00, 0, true));
//        newItemList = mergeSort(newItemList);
//        recycleViewAdapter.notifyDataSetChanged();
    }

    public void initRecyclerView(List<DisplayObject> itemList) {
        newItemList = itemList;
        layoutManager = new LinearLayoutManager(getActivity());
        recycleViewAdapter = new RecycleViewAdapter(getActivity(), newItemList, getActivity());
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);

    }

    @Override
    public List<DisplayObject> mergeSort(List<DisplayObject> itemList){
        Log.d(TAG, "mergeSort: is called");
        if(itemList.size() <= 1){
            return itemList;
        }

        List<DisplayObject> result = new ArrayList<>();
        List<DisplayObject> left = new ArrayList<>();
        List<DisplayObject> right = new ArrayList<>();

        int midpoint = (itemList.size()/2);

        for(int i = 0; i < midpoint; i++){
            left.add(itemList.get(i));
        }
        for(int j = midpoint; j < itemList.size(); j++){
            right.add(itemList.get(j));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    public List<DisplayObject> merge(List<DisplayObject> left, List<DisplayObject> right){
        List<DisplayObject> result = new ArrayList<>();

        while((!left.isEmpty()) && (!right.isEmpty())){
            if(left.get(0).getPrice()>right.get(0).getPrice()){
                result.add(left.get(0));
                left.remove(0);
            }
            else if(right.get(0).getPrice()>left.get(0).getPrice()){
                result.add(right.get(0));
                right.remove(0);
            }
        }

        while(!left.isEmpty()){
            result.add(left.get(0));
            left.remove(0);

        }

        while(!right.isEmpty()){
            result.add(right.get(0));
            right.remove(0);

        }

        return result;
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
