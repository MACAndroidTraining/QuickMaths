package com.example.admin.quickmaths.view.placesActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        DisplayObject d = getIntent().getParcelableExtra("deal");

        String store = d.getStore();

        if( store.contains( ".com" ))
            store = d.getStore().substring(0, d.getStore().indexOf(".com"));

        Toast.makeText(this, "" + store, Toast.LENGTH_SHORT).show();
    }
}
