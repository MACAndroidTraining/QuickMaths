package com.example.admin.quickmaths;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.placesActivity.GooglePlacesActivity;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;

public class DetailActivity extends Fragment {

    View myView;
    Button btnDetailAdd, btnDetailMap;
    TextView tvDetailName;
    String storeName;
    ShareButton shareButton;
    DisplayObject displayObject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //        //facebook sdk initialization in fragment
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        myView = inflater.inflate(R.layout.activity_detail, container, false);

        //Share Dialog
        //You cannot preset the shared link in design time, if you do so, the fb share button will
        //look disabled. You need to set in the code as below
        shareButton = myView.findViewById(R.id.facebook_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
//                .setContentTitle("QuickMaths")//switches title during post description, but reverts to url title and description by default
//                .setContentDescription(String.valueOf("10.00"))
                .setContentUrl(Uri.parse("http://www.google.com"))
//                .setImageUrl(Uri.parse("http://www.ssbwiki.com/images/thumb/2/29/Yoshi_SSB4.png/200px-Yoshi_SSB4.png"))
                .build();
        shareButton.setShareContent(content);

        //Like view object todo: deprecation noted down
        LikeView likeView = myView.findViewById(R.id.like_view);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/FacebookDevelopers",
                LikeView.ObjectType.PAGE);

        init();

        return myView;
    }

    private void init() {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);

        final DisplayObject d = getArguments().getParcelable("displayObject");

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
                DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                long isSaved = databaseHelper.saveOffer(d);
                if(isSaved == -1){
                    Toast.makeText(getActivity(), "Duplicate Offer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                }
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
