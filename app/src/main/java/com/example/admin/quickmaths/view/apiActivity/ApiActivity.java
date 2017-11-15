package com.example.admin.quickmaths.view.apiActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends AppCompatActivity implements ApiActivityContract.View {

    private static final String TAG = "ApiActivity";

    @BindView(R.id.tvUPC)
    TextView upcTextView;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;

    int pageCall = 1;
    RecycleViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    ApiActivityPresenter presenter = new ApiActivityPresenter();

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
    }

    public void initRecyclerView(List<DisplayObject> itemList) {
        layoutManager = new LinearLayoutManager(this);
        recycleViewAdapter = new RecycleViewAdapter(itemList);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setAdapter(recycleViewAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError(String error) {

    }
}
