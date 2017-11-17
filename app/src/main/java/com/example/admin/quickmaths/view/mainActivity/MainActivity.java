package com.example.admin.quickmaths.view.mainActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.admin.quickmaths.CartActivity;
import com.example.admin.quickmaths.FaceBookLoginActivity;
import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.ZxingActivity;
import com.example.admin.quickmaths.data.RetrofitHelper;
import com.example.admin.quickmaths.model.UPCItemDB.Offer;
import com.example.admin.quickmaths.model.UPCItemDB.SearchResult;
import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.apiActivity.ApiActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.PACKAGE_USAGE_STATS;
import static android.Manifest.permission_group.LOCATION;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";
    // used while getting the permissions from the user to use the camera
    private static final int REQUEST_CAMERA = 1;
    private MediaPlayer beep;

    // the view to scan the code
//    @BindView(R.id.scannerView)
//    ZXingScannerView mScannerView;
//    @BindView(R.id.mySearchView)
//    SearchView mySearchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.nav_view)
//    NavigationView navView;
//    @BindView(R.id.drawerLayout)
//    DrawerLayout drawerLayout;

    String query;

    boolean search = false;

    boolean didsearch = false;

    Fragment currentFrag = null;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

//        beep = MediaPlayer.create(this, R.raw.barcode_beep_sound_effect);
        beep = MediaPlayer.create(this, R.raw.skraaa);

//        //go straight to api
//        String upc = "813516025388"; // refurbished apple ipod nano, 16bg, blue
//        String upc = "039400019770"; // Bush's best brown sugar hickory baked beans, 28 oz
//        String upc = "014633733877"; // Mirror's Edge Catalyst - PlayStation 4
//        String upc = "045496743925";
//        Intent intent = new Intent(this, ApiActivity.class);
//        intent.putExtra("query", upc);
//        startActivity(intent);

        //  check version.
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.M) {
            // if proper version, check camera permissions.
            if ( !checkPermissionCamera())
                requestPermissionCamera();

            if( !checkPermissionLocation() )
                requestPermissionLocation();
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = findViewById(R.id.mySearchView);

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: ");
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(TAG, "onNewIntent: search");
            query = intent.getStringExtra(SearchManager.QUERY);
//            recipeList.clear();
//            presenter.getRecipes(0, query);
            FragmentManager fragmentManager = getFragmentManager();

            Bundle args = new Bundle();
            args.putString("query",query);
            ApiActivity frag = new ApiActivity();
            frag.setArguments(args);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, frag)
                    .addToBackStack("api_activity")
                    .commit();

            currentFrag = frag;
            search = true;
            didsearch = true;
        }

        //hide keyboard after search
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean checkPermissionCamera() {
        Log.d(TAG, "checkPermissionCamera: ");
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) ==
                PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermissionCamera() {
        Log.d(TAG, "requestPermissionCamera: ");
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    private boolean checkPermissionLocation() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermissionLocation() {
        Log.d(TAG, "requestPermissionCamera: ");
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 200);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // called after the user is prompted to grant the app permission to use the camera.
        Log.d(TAG, "onRequestPermissionsResult: ");

        switch (requestCode) {

            case REQUEST_CAMERA:
                if (grantResults.length > 0) {
                    // if something was returned.
                    boolean cameraAccepted = (grantResults[0] == PackageManager.PERMISSION_GRANTED);
                    if (cameraAccepted) {
                        // if permission granted.
                        Toast.makeText(getApplicationContext(),
                                "Permission Granted, Now you can access camera",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Permission Denied, You cannot access and camera",
                                Toast.LENGTH_LONG).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel(
                                        "You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });

                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public void setdidsearch(){
        didsearch = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        searchView.clearFocus(); // close the keyboard on load

        if(search){
            search = false;
            return;
        }

        if(!didsearch){
            int currentapiVersion = Build.VERSION.SDK_INT;
            if (currentapiVersion >= Build.VERSION_CODES.M) {
                if (checkPermissionCamera()) {

                    //start fragment
                    FragmentManager fragmentManager = getFragmentManager();
                    ZxingActivity frag = new ZxingActivity();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content_frame, frag)
//                        .addToBackStack("zxing_activity")
                            .commit();

//                if (mScannerView == null) {
//                    // check if the scanner view is null. If so, create a new one.
//                    mScannerView = new ZXingScannerView(this);
//                    setContentView(mScannerView);
//                }
//                mScannerView.setResultHandler(this);
//                mScannerView.startCamera();
                    Log.d(TAG, "onResume: Camera Started");
                    currentFrag = frag;
                } else {
                    requestPermissionCamera();
                }
            }
        }


    }

//    private void showUPCAlert( final String result ) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
////        builder.setTitle("Scan Result");
//        builder.setTitle("Quick Mafs");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                mScannerView.resumeCameraPreview(MainActivity.this);
//            }
//        });
//
//        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
//                startActivity(browserIntent);
//            }
//        });
//
//        builder.setMessage( result );
//        AlertDialog alert1 = builder.create();
//        alert1.show();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        Intent intent;
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_camera) {

//            ZxingActivity zxingActivity = (ZxingActivity) getFragmentManager().findFragmentByTag(ZXINGTAG);
//            fragmentManager.beginTransaction()
//                    .remove(zxingActivity);
            ZxingActivity frag = new ZxingActivity();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, frag)
                    .commit();
            currentFrag = frag;

        } else if (id == R.id.nav_favorites) {

            CartActivity frag = new CartActivity();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, frag)
                    .addToBackStack("cart_activity")
                    .commit();
            currentFrag = frag;

//            intent = new Intent(this, CartActivity.class);
//            startActivity(intent);

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_social) {
            FaceBookLoginActivity frag = new FaceBookLoginActivity();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, frag)
                    .addToBackStack("facebook_activity")
                    .commit();
            currentFrag = frag;
        }

        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
//        if(currentFrag != null){
//            Log.d(TAG, "onStart: " + currentFrag);
//            FragmentManager fragmentManager = getFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.content_frame, currentFrag)
//                    .addToBackStack("cart_activity")
//                    .commit();
//        }
    }

    public void setCurrentFrag(Fragment frag){
        currentFrag = frag;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }
}