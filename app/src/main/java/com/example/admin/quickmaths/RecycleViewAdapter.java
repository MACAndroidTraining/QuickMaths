package com.example.admin.quickmaths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.model.Search.Item;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/14/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    List<Item> itemList = new ArrayList<>();
    Context context;
    DecimalFormat df = new DecimalFormat("#.00");

    public RecycleViewAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.item = item;
        Glide.with(context).load(item.getThumbnailImage()).into(holder.ivItemImage);
        holder.tvItemName.setText(item.getName());
        holder.tvItemPrice.setText("$" + String.valueOf(df.format(item.getSalePrice())));
        holder.tvItemDescription.setText(item.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemImage;
        TextView tvItemName, tvItemPrice, tvItemDescription;
        Item item;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, ItemViewActivity.class);
//                    intent.putExtra("item", item);
//                    context.startActivity(intent);
                }
            });

            ivItemImage = itemView.findViewById(R.id.ivItemImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvItemDescription = itemView.findViewById(R.id.tvItemDescription);

        }
    }
}
