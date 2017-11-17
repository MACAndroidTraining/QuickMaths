package com.example.admin.quickmaths;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.detailsActivity.DetailsActivity;
import com.example.admin.quickmaths.view.placesActivity.GooglePlacesActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;

import java.util.concurrent.Callable;

public class DetailActivity extends Fragment {

    View myView;
    ImageButton btnDetailAdd;
    Button btnDetailMap;
    TextView tvDetailName, tvDetailStore, tvDetailPrice, tvDetailLink, tvDetailDescription;
    ImageView ivDetailImage;
    String storeName;
    //Creating DisplayObject object to return values from wrapper
    DisplayObject displayObject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //        //facebook sdk initialization in fragment
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        myView = inflater.inflate(R.layout.activity_detail, container, false);

        Bundle b = getArguments();
        displayObject = (DisplayObject) b.get("displayObject");
        Log.d(TAG, "onCreateView: url=" + displayObject.getLink());

        //btnShare Bind
        btnShare = myView.findViewById(R.id.btnShare);
        //Share Dialog
        //You cannot preset the shared link in design time, if you do so, the fb share button will
        //look disabled. You need to set in the code as below
        shareButton = myView.findViewById(R.id.facebook_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
//                .setContentTitle("QuickMaths")//switches title during post description, but reverts to url title and description by default
//                .setContentDescription(String.valueOf("10.00"))
                .setContentUrl(Uri.parse(displayObject.getLink()))
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

        if(d.getStore() != null) {
            Log.d(TAG, "init: " + d.getStore());
            storeName = d.getStore();
        }
        else
            storeName = "";

        tvDetailName = myView.findViewById(R.id.tvDetailName);
        btnDetailAdd = myView.findViewById(R.id.btnDetailAdd);
        btnDetailMap = myView.findViewById(R.id.btnDetailMap);
        tvDetailStore = myView.findViewById(R.id.tvDetailStore);
        tvDetailPrice = myView.findViewById(R.id.tvDetailPrice);
        tvDetailLink = myView.findViewById(R.id.tvDetailLink);
        ivDetailImage = myView.findViewById(R.id.ivDetailImage);
        tvDetailDescription = myView.findViewById(R.id.tvDetailDescription);

        tvDetailName.setText(d.getProduct());
        tvDetailStore.setText("Store: "+d.getStore());
        tvDetailPrice.setText("Price: $"+String.valueOf(d.getPrice()));
        tvDetailLink.setText(d.getLink());
        tvDetailDescription.setText(d.getDescription());
        Glide.with(this).load(d.getImageUrl()).into(ivDetailImage);

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

        facebookActivity();
    }

    //creating share button, intent, and hardcode text
    Button btnShare;
    Intent shareIntent;
    String shareBody = "This is a great app for the lowest prices near you!";
    ShareButton shareButton;

    //creating Item object from model.UPCItemDB.Item
//    Item item = new Item();

    private static final String TAG = "Facebook Login";

    //callback manager
    private CallbackManager mFacebookCallbackManager;

    private void facebookActivity(){

        FacebookSdk.sdkInitialize(getActivity());

        //btnShare Bind
        btnShare = myView.findViewById(R.id.btnShare);

        //initializing FB objects
        mFacebookCallbackManager = CallbackManager.Factory.create();

        //image view and text view for login results
        final ImageView imageView = myView.findViewById(R.id.my_image_view);
        final TextView textView = myView.findViewById(R.id.tvWelcome);

        //token tracker
        AccessTokenTracker mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            }
        };

        //tracking new logins from device
        ProfileTracker mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                textView.setText(displayWelcomeMessage(currentProfile));
            }
        };
        mTokenTracker.startTracking();
        mProfileTracker.startTracking();

        //request permission for retrieving user's friend's list and login btn
        LoginButton mFacebookSignInButton = myView.findViewById(R.id.facebook_sign_in_button);
        mFacebookSignInButton.setReadPermissions("user_friends");

        //fb callback object
        FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
            //retrieving user profile img and first name to welcome the user
            @Override
            public void onSuccess(final LoginResult loginResult) {
                //TODO: Use the Profile class to get information about the current user.

                //retrieving access token and user profile
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                displayWelcomeMessage(profile);

                //retrieving user profile img
                Uri imageLink = profile.getProfilePictureUri(250, 250);

                //Welcoming user via text view---removed if statement for now
                // TODO:find why it returns null as if statement
                Glide.with(getActivity())
                        .load(imageLink)
                        .into(imageView);
                textView.setText(String.format("%s%s", getString(R.string.greet),
                        profile.getFirstName()));

            }

            @Override
            public void onCancel() {
                textView.setText(R.string.login_cancel);
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(DetailsActivity.class.getCanonicalName(), error.getMessage());
                handleSignInResult(null);
            }
        };

        //registering callback on login
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager, mCallBack);

//        Share Dialog
//        You cannot preset the shared link in design time, if you do so, the fb share button will
//        look disabled. You need to set in the code as below
        shareButton = myView.findViewById(R.id.facebook_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("QuickMaths")//switches title during post description, but reverts to url title and description by default
                .setContentDescription(String.valueOf(displayObject.getPrice()))
                .setContentUrl(Uri.parse(displayObject.getLink()))
//                .setImageUrl(Uri.parse("http://www.ssbwiki.com/images/thumb/2/29/Yoshi_SSB4.png/200px-Yoshi_SSB4.png"))
                .build();
        shareButton.setShareContent(content);

        //Like view object todo: deprecation noted down
        LikeView likeView = myView.findViewById(R.id.like_view);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/FacebookDevelopers",
                LikeView.ObjectType.PAGE);

        setshareclicklistener();
    }

    public void setshareclicklistener() {

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                //TODO: general implicit share button is currently hardcoded
                shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "QuickMaths: " + displayObject.getLink());
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share via "));
            }
        });

    }

    //returning result from activity
    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleSignInResult(Callable<Void> callable) {

        Log.d(TAG, "handleSignInResult: Signed in");
    }

    //implicit intent activity on share btn
    private String displayWelcomeMessage(Profile profile) {
        StringBuilder stringBuffer = new StringBuilder();
        if (profile != null) {
            stringBuffer.append("Welcome ").append(profile.getName());
        }
        return stringBuffer.toString();
    }




}
