package com.example.admin.quickmaths;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "Facebook Login";

    //callback manager
    private CallbackManager mFacebookCallbackManager;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;

    //share dialog for share button
//    ShareDialog shareDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        //initializing FB objects
        mFacebookCallbackManager = CallbackManager.Factory.create();
//        shareDialog = new ShareDialog(this);
        setContentView(R.layout.activity_login);

        //image view and text view for login results
        final ImageView imageView = findViewById(R.id.my_image_view);
        final TextView textView = findViewById(R.id.tvWelcome);

//        ShareButton shareButton = findViewById(R.id.facebook_share_button);
        //need to add content to object content for sharing

        //token tracker
        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            }
        };

        //tracking new logins from device
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                textView.setText(displayWelcomeMessage(currentProfile));
            }
        };
        mTokenTracker.startTracking();
        mProfileTracker.startTracking();



        //request permission for retrieving user's friend's list and login btn
        LoginButton mFacebookSignInButton = findViewById(R.id.facebook_sign_in_button);
        mFacebookSignInButton.setReadPermissions("user_friends");

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

                        Glide.with(LoginActivity.this)
                                .load(imageLink)
                                .into(imageView);
                        textView.setText("Welcome " + profile.getFirstName());

                    }

                    @Override
                    public void onCancel() {
                        handleSignInResult(null);
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(LoginActivity.class.getCanonicalName(), error.getMessage());
                        handleSignInResult(null);
                    }
                };

        //registering callback on login
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager, mCallBack);


        //facebook showing ShareDialog
//        if (ShareDialog.canShow(ShareLinkContent.class)) {
//            ShareLinkContent linkContent = new ShareLinkContent.Builder()
//                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))//example URL
//                    .build();
//            shareDialog.show(linkContent);
//            shareButton.setShareContent(linkContent);//TODO: add data to content for sharing
//
//        }

//        MessageDialog.show(MainActivity.class, content);
//        shareButton.setShareContent(linkContent);//TODO: add data to content for sharing



    }

    //returning result from activity
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleSignInResult(Callable<Void> callable) {

        Log.d(TAG, "handleSignInResult: Signed in");
    }


    private String displayWelcomeMessage(Profile profile) {
        StringBuilder stringBuffer = new StringBuilder();
        if (profile != null) {
            stringBuffer.append("Welcome ").append(profile.getName());
        }
        return stringBuffer.toString();


}