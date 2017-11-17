package com.example.admin.quickmaths;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.placesActivity.GooglePlacesActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends Fragment {

    private static final String TAG = "CartActivity";
    private List<DisplayObject> cartList;
    private CartListAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;

    View myView;

    ImageButton btnCartCheckout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_cart, container, false);
        init();
        return myView;
    }

    private void init() {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart);

//        Toolbar toolbar = myView.findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        btnCartCheckout = myView.findViewById(R.id.btnCartCheckout);

        btnCartCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GooglePlacesActivity.class);
                List<String> storeName = new ArrayList<>();

                for(DisplayObject object: cartList) {
                    storeName.add(object.getStore());
                }

                intent.putStringArrayListExtra("stores", (ArrayList<String>) storeName);
                startActivity(intent);
            }
        });

        cartList = new ArrayList<>();
        prepareCart();

        mAdapter = new CartListAdapter(getActivity(), cartList, getActivity());

        RecyclerView recyclerView = myView.findViewById(R.id.rvCart);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

//        NavigationView navigationView = myView.findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

    }

    private void prepareCart() {

        //dummy data
//        DisplayObject item1 = new DisplayObject("product","Walmart", "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg", 1.50, 34.00, false);
//        DisplayObject item2 = new DisplayObject("product","Best Buy", "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg", 1.30, 34.00, false);
//        DisplayObject item3 = new DisplayObject("product","Target", "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg", 1.10, 34.00, false);
//        DisplayObject item4 = new DisplayObject("product","Big Lots", "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg", 1.40, 34.00, false);
//        DisplayObject item5 = new DisplayObject("product","Kmart", "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg", 1.20, 34.00, false);
//
//
//        cartList.add(item1);
//        cartList.add(item2);
//        cartList.add(item3);
//        cartList.add(item4);
//        cartList.add(item5);


        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());

        cartList = databaseHelper.getOfferList();

    }

}
