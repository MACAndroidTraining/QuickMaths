package com.example.admin.quickmaths;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

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

//        ShareButton shareButton = findViewById(R.id.facebook_share_button);
        //need to add content to object content for sharing

        //token tracker
        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            }
        };

        LoginButton mFacebookSignInButton = findViewById(R.id.facebook_sign_in_button);
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {
                        //TODO: Use the Profile class to get information about the current user.
                        handleSignInResult(new Callable<Void>() {
                            @Override
                            public Void call() throws Exception {
                                LoginManager.getInstance().logOut();
                                return null;
                            }
                        });
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
                }

        );


        //facebook showing ShareDialog
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))//example URL
                    .build();
            shareDialog.show(linkContent);
            shareButton.setShareContent(linkContent);//TODO: add data to content for sharing

        }

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


}