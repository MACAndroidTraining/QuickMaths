package com.example.admin.quickmaths.view.placesActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.view.loginActivity.LoginActivity;
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

public class PlacesActivity extends AppCompatActivity {

    //creating share button, intent, and hardcode text
    Button btnShare;
    Intent shareIntent;
    String shareBody = "This is a great app! You should try it now!";
    ShareButton shareButton;

    private static final String TAG = "Facebook Login";

    //callback manager
    private CallbackManager mFacebookCallbackManager;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        FacebookSdk.sdkInitialize(getApplicationContext());

        //btnShare Bind
        btnShare = findViewById(R.id.btnShare);

        //initializing FB objects
        mFacebookCallbackManager = CallbackManager.Factory.create();

        //image view and text view for login results
        final ImageView imageView = findViewById(R.id.my_image_view);
        final TextView textView = findViewById(R.id.tvWelcome);

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

                Glide.with(LoginActivity.this)
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
                Log.d(LoginActivity.class.getCanonicalName(), error.getMessage());
                handleSignInResult(null);
            }
        };

        //registering callback on login
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager, mCallBack);

        //TODO: either explicitly open fb with fb btn or remove it: done
        //Share Dialog
        //You cannot preset the shared link in design time, if you do so, the fb share button will
        //look disabled. You need to set in the code as below
        shareButton = findViewById(R.id.facebook_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("Hello Guys")
                .setContentDescription(
                        "Coder who learned and share")
                .setContentUrl(Uri.parse("http://instinctcoder.com"))
                .setImageUrl(Uri.parse("https://scontent-sin1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12936641_845624472216348_1810921572759298872_n.jpg?oh=72421b8fa60d05e68c6fedbb824adfbf&oe=577949AA"))

                .build();
        shareButton.setShareContent(content);

        //Like view object todo: deprecation noted down
        LikeView likeView = findViewById(R.id.like_view);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/FacebookDevelopers",
                LikeView.ObjectType.PAGE);
    }

    public void btnShare(View view) {
        //TODO: general implicit share button is currently hardcoded
        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My App.");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent, "Share via "));
    }
}
