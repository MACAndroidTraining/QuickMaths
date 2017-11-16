package com.example.admin.quickmaths;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.databinding.ListItemBinding;
import com.example.admin.quickmaths.databinding.StepItemBinding;
import com.example.admin.quickmaths.model.google.Location;
import com.example.admin.quickmaths.model.google.Photo;
import com.example.admin.quickmaths.model.google.Result;
import com.example.admin.quickmaths.model.google.Step;

import java.util.ArrayList;
import java.util.List;

public class GooglePlacesAdapter extends RecyclerView.Adapter<GooglePlacesAdapter.ViewHolder>{

    private List<Result> resultList;
    private Context context;
    private List<Step> stepList;
    private List<String> wayPoints = new ArrayList<>();


    // TODO: 11/16/2017 Create a seperate adapter
    public GooglePlacesAdapter(List<Result> resultList) { this.resultList = resultList; }

    //Added a random parameter to the constructor so that i can overload the adapter.
    public GooglePlacesAdapter(List<Step> stepList, Object anything) {
        this.stepList = stepList;
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
                String restaurantpic = "https://maps.googleapis.com/maps/api/place/photo?" +
                        "maxheight=" + photo.getHeight() +
                        "&photoreference=" + photo.getPhotoReference() +
                        "&key=" + GooglePlacesRemoteServiceHelper.PLACES_API_KEY;

                holder.mListBinding.tvPlaceName.setText(result.getName());
                Glide.with(context)
                        .load(restaurantpic)
                        .into(holder.mListBinding.ivPlaceImage);

                holder.mListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Location destinationLocation = result.getGeometry().getLocation();
                        String destinationCoordintes = destinationLocation.getLat() + "," + destinationLocation.getLng();
                        wayPoints.add(destinationCoordintes);
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

    public List<String> getWayPoints() {
        return wayPoints;
    }

}
