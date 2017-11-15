package com.example.admin.quickmaths.view.mainActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.view.apiActivity.ApiActivity;
import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final String TAG = "MainActivity";
    // used while getting the permissions from the user to use the camera
    private static final int REQUEST_CAMERA = 1;
    private MediaPlayer beep;

    // the view to scan the code
    @BindView(R.id.scannerView)
    ZXingScannerView mScannerView;
    @BindView(R.id.mySearchView)
    SearchView mySearchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mScannerView = findViewById(R.id.scannerView);

//        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        beep = MediaPlayer.create(this, R.raw.barcode_beep_sound_effect);
        beep = MediaPlayer.create(this, R.raw.skraaa);

//        //go straight to api
//        String upc = "813516025388"; // refurbished apple ipod nano, 16bg, blue
//        String upc = "039400019770"; // Bush's best brown sugar hickory baked beans, 28 oz
        String upc = "014633733877"; // Mirror's Edge Catalyst - PlayStation 4
        Intent intent = new Intent(this, ApiActivity.class);
        intent.putExtra("query", upc);
        startActivity(intent);

        //  check version.
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.M) {
            // if proper version, check camera permissions.
            if (checkPermission()) {
//                Toast.makeText(getApplicationContext(),
//                        "Permission already granted",
//                        Toast.LENGTH_LONG).show();

            } else {
                requestPermission();
            }
        }
    }

    private boolean checkPermission() {
        Log.d(TAG, "checkPermission: ");
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) ==
                PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        Log.d(TAG, "requestPermission: ");
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
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

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if (mScannerView == null) {
                    // check if the scanner view is null. If so, create a new one.
                    mScannerView = new ZXingScannerView(this);
                    setContentView(mScannerView);
                }
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
                Log.d(TAG, "onResume: Camera Started");
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.d(TAG, "handleResult: ");

        beep.start();

        final String result = rawResult.getText();
        Log.d("QRCodeScanner", rawResult.getText());
        Log.d("QRCodeScanner", rawResult.getBarcodeFormat().toString());

//        showUPCAlert( result );
        Intent intent = new Intent(this, ApiActivity.class);
        intent.putExtra("query", rawResult.getText());
        startActivity(intent);
    }

    private void showUPCAlert( final String result ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
        builder.setTitle("Quick Mafs");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mScannerView.resumeCameraPreview(MainActivity.this);
            }
        });

        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                startActivity(browserIntent);
            }
        });

        builder.setMessage( result );
        AlertDialog alert1 = builder.create();
        alert1.show();
    }

}