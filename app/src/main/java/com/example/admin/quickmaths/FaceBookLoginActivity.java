package com.example.admin.quickmaths;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.view.detailsActivity.DetailsActivity;
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

import java.util.concurrent.Callable;

public class FaceBookLoginActivity extends Fragment {

    View myView;

    private static final String TAG = "Facebook Login";

    //callback manager
    private CallbackManager mFacebookCallbackManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_face_book_login, container, false);
        init();
        return myView;
    }

    private void init(){
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
    }

    //implicit intent activity on share btn
    private String displayWelcomeMessage(Profile profile) {
        StringBuilder stringBuffer = new StringBuilder();
        if (profile != null) {
            stringBuffer.append("Welcome ").append(profile.getName());
        }
        return stringBuffer.toString();
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

}
