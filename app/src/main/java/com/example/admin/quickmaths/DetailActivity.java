package com.example.admin.quickmaths;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.quickmaths.model.bestBuy.Detail;
import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.apiActivity.ApiActivity;
import com.example.admin.quickmaths.view.placesActivity.GooglePlacesActivity;

public class DetailActivity extends Fragment {

    View myView;
    Button btnDetailAdd, btnDetailMap;
    TextView tvDetailName;
    String storeName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_detail, container, false);
        init();
        return myView;
    }

    private void init() {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);

        DisplayObject d = getArguments().getParcelable("displayObject");

        if(d.getStore() != null)
            storeName = d.getStore();
        else
            storeName = "";

        tvDetailName = myView.findViewById(R.id.tvDetailName);
        btnDetailAdd = myView.findViewById(R.id.btnDetailAdd);
        btnDetailMap = myView.findViewById(R.id.btnDetailMap);

        tvDetailName.setText(d.getStore());

        btnDetailAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        //Activates the GooglePlacesActivity in the placesActivity directory under the view directory
        btnDetailMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GooglePlacesActivity.class);
                intent.putExtra("storeName", storeName);
                startActivity(intent);
            }
        });

    }



}
