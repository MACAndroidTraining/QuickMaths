package com.example.admin.quickmaths;

import android.app.Activity;
import android.content.Context;

import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.apiActivity.RecycleViewAdapter;

import java.util.List;

/**
 * Created by joseph on 11/15/17.
 */

public class CartListAdapter extends RecycleViewAdapter implements ItemTouchHelperAdapter {


    public CartListAdapter(Context context, List<DisplayObject> itemList, Activity activity) {
        super(context, itemList, activity);
    }

    @Override
    public void onItemDismiss(int position) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getactivity());
        databaseHelper.deleteOffer(itemList.get(position).getProduct(),itemList.get(position).getStore());
        itemList.remove(position);
        notifyItemRemoved(position);
    }


}
