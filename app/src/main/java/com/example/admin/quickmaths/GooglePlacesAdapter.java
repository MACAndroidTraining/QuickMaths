package com.example.admin.quickmaths;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.databinding.ListItemBinding;
import com.example.admin.quickmaths.databinding.StepItemBinding;
import com.example.admin.quickmaths.model.Location;
import com.example.admin.quickmaths.model.Photo;
import com.example.admin.quickmaths.model.Result;
import com.example.admin.quickmaths.model.Step;
import com.example.admin.quickmaths.presenter.GooglePlacesPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Jason on 11/4/2017.
 */

public class GooglePlacesAdapter extends RecyclerView.Adapter<GooglePlacesAdapter.ViewHolder>{

    List<Result> resultList;
    Context context;
    GooglePlacesPresenter presenter;
    List<Step> stepList;


    public GooglePlacesAdapter(List<Result> resultList, GooglePlacesPresenter presenter) {
        this.resultList = resultList;
        this.presenter = presenter;
        stepList = null;
    }

    //Added a random parameter to the constructor so that i can overload it.
    public GooglePlacesAdapter(List<Step> stepList, GooglePlacesPresenter presenter, Object anything) {
        this.stepList = stepList;
        this.presenter = presenter;
        resultList = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        ListItemBinding listBinding;
        StepItemBinding stepItemBinding;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if(resultList != null) {
            listBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
            return new ViewHolder(listBinding);
        } else {
            stepItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.step_item, parent, false);
            return new ViewHolder(stepItemBinding);
        }

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(resultList != null) {
            final Result result = resultList.get(position);
            List<Photo> photoList = result.getPhotos();
            if (photoList != null) {
                Photo photo = photoList.get(0);

                //I tried use the api to no avail. Finally gave up and did this instead
                String restaurantpic = "https://maps.googleapis.com/maps/api/place/photo?" +
                        "maxheight=" + photo.getHeight() +
                        "&photoreference=" + photo.getPhotoReference() +
                        "&key=" + GooglePlacesRemoteServiceHelper.PLACES_API_KEY;

                holder.mListBinding.tvPlaceName.setText(result.getName());
                Glide.with(context)
                        .load(restaurantpic)
                        .error(R.drawable.ic_launcher_background)
                        .into(holder.mListBinding.ivPlaceImage);

                holder.mListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Location destinationLocation = result.getGeometry().getLocation();
                        String destinationCoordintes = destinationLocation.getLat() + "," + destinationLocation.getLng();
                        presenter.getDirections(destinationCoordintes);
                    }
                });

            }
        } else {
            Step step = stepList.get(position);
            holder.mStepBinding.tvStep.setText(Html.fromHtml(step.getHtmlInstructions()));
        }
    }

    @Override
    public int getItemCount() {
        if(resultList != null)
            return resultList.size();
        else
            return stepList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding mListBinding;
        StepItemBinding mStepBinding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            mListBinding = binding;
        }

        public ViewHolder(StepItemBinding binding) {
            super(binding.getRoot());
            mStepBinding = binding;
        }
    }


}