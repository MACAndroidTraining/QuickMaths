package com.example.admin.quickmaths;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quickmaths.view.apiActivity.ApiActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ZxingActivity extends Fragment implements ZXingScannerView.ResultHandler{

    private static final String TAG = "ZxingActivity";
    View myView;

    // used while getting the permissions from the user to use the camera
    private static final int REQUEST_CAMERA = 1;
    private MediaPlayer beep;

    ZXingScannerView mScannerView;
    SearchView mySearchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_zxing, container, false);
        init();
        return myView;
    }

    private void init() {

        mScannerView = myView.findViewById(R.id.scannerView);
        mySearchView = myView.findViewById(R.id.mySearchView);


//        beep = MediaPlayer.create(this, R.raw.barcode_beep_sound_effect);
        beep = MediaPlayer.create(getActivity(), R.raw.skraaa);

        if (mScannerView == null) {
            // check if the scanner view is null. If so, create a new one.
            mScannerView = new ZXingScannerView(getActivity());
            getActivity().setContentView(mScannerView);
        }
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
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
//        Intent intent = new Intent(getActivity(), ApiActivity.class);
//        intent.putExtra("query", rawResult.getText());
//        startActivity(intent);

        FragmentManager fragmentManager = getFragmentManager();

        Bundle args = new Bundle();
        args.putString("query",rawResult.getText());
        ApiActivity frag = new ApiActivity();
        frag.setArguments(args);
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, frag)
                .addToBackStack("api_activity")
                .commit();

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
}
