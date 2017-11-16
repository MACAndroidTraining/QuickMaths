package com.example.admin.quickmaths.view.apiActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends AppCompatActivity implements ApiActivityContract.View{

    private static final String TAG = "ApiActivity";

    @BindView(R.id.tvUPC)
    TextView upcTextView;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;

    int pageCall = 1;
    RecycleViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    ApiActivityPresenter presenter = new ApiActivityPresenter();

    List<DisplayObject> newItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);

        presenter.attachView(this);
        //set up dagger

        String upc = getIntent().getStringExtra("query");
        upcTextView.setText("Results for: " + upc);

        presenter.makeCall(pageCall, upc);
//        newItemList.add(new DisplayObject("food", "Mac's", "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg", 2.00, 0, true));
//        newItemList = mergeSort(newItemList);
//        recycleViewAdapter.notifyDataSetChanged();
    }

    public void initRecyclerView(List<DisplayObject> itemList) {
        newItemList = itemList;
        layoutManager = new LinearLayoutManager(this);
        recycleViewAdapter = new RecycleViewAdapter(this, newItemList);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);

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
