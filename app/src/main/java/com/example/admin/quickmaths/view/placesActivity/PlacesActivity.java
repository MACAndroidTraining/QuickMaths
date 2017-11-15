package com.example.admin.quickmaths.view.placesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.quickmaths.R;
import com.facebook.share.widget.ShareButton;

public class PlacesActivity extends AppCompatActivity {

    //creating share button, intent, and hardcode text
    Button btnShare;
    Intent shareIntent;
    String shareBody = "This is a great app! You should try it now!";
    ShareButton shareButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
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
