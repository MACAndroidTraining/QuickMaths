package com.example.admin.quickmaths;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.databinding.ListItemBinding;
import com.example.admin.quickmaths.model.Photo;
import com.example.admin.quickmaths.model.Result;
import com.example.admin.quickmaths.presenter.GooglePlacesPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Jason on 11/4/2017.
 */

public class GooglePlacesAdapter extends RecyclerView.Adapter<GooglePlacesAdapter.ViewHolder>{

    List<Result> resultList = new ArrayList<>();
    Context context;
    GooglePlacesPresenter presenter;

    public GooglePlacesAdapter(List<Result> resultList, GooglePlacesPresenter presenter) {
        this.resultList = resultList;
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Result result = resultList.get(position);
        List<Photo> photoList = result.getPhotos();
        if(photoList != null) {
            Photo photo = photoList.get(0);

            //I tried use the api to no avail. Finally gave up and did this instead
            String restaurantpic = "https://maps.googleapis.com/maps/api/place/photo?" +
                    "maxheight=" + photo.getHeight() +
                    "&photoreference=" +photo.getPhotoReference() +
                    "&key="+GooglePlacesRemoteServiceHelper.PLACES_API_KEY;

            holder.mBinding.tvPlaceName.setText(result.getName());
            Glide.with(context)
                    .load(restaurantpic)
                    .into(holder.mBinding.ivPlaceImage);

        }
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding mBinding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }


}

