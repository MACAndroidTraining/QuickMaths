package com.example.admin.quickmaths;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private static final String TAG = "CartActivity";
    private List<DisplayObject> cartList;
    private CartListAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = new ArrayList<>();
        prepareCart();

        mAdapter = new CartListAdapter(cartList);

        RecyclerView recyclerView = findViewById(R.id.rvCart);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private void prepareCart() {

        DisplayObject item1 = new DisplayObject("Walmart", 1.50, 34.00, R.drawable.walmart);
        DisplayObject item2 = new DisplayObject("Best Buy", 1.30, 34.00, R.drawable.walmart);
        DisplayObject item3 = new DisplayObject("Target", 1.10, 34.00, R.drawable.walmart);
        DisplayObject item4 = new DisplayObject("Big Lots", 1.40, 34.00, R.drawable.walmart);
        DisplayObject item5 = new DisplayObject("Kmart", 1.20, 34.00, R.drawable.walmart);

        cartList.add(item1);
        cartList.add(item2);
        cartList.add(item3);
        cartList.add(item4);
        cartList.add(item5);

    }

}
