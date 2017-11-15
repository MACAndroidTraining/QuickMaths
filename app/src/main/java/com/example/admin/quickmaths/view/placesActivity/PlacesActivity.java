package com.example.admin.quickmaths.view.placesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.quickmaths.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.widget.LoginButton;
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
