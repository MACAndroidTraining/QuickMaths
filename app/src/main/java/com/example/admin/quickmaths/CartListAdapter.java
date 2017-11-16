package com.example.admin.quickmaths;

import android.content.Context;

import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.apiActivity.RecycleViewAdapter;

import java.util.List;

/**
 * Created by joseph on 11/15/17.
 */

public class CartListAdapter extends RecycleViewAdapter implements ItemTouchHelperAdapter {


    public CartListAdapter(Context context, List<DisplayObject> itemList) {
        super(context, itemList);
    }

    @Override
    public void onItemDismiss(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }


}
