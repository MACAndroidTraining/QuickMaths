package com.example.admin.quickmaths.view.apiActivity;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.data.RetrofitHelper;
import com.example.admin.quickmaths.model.Search.Item;
import com.example.admin.quickmaths.model.Search.Search;
import com.example.admin.quickmaths.model.display.DisplayObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/13/2017.
 */

public class ApiActivityPresenter implements ApiActivityContract.Presenter {

    private static final String TAG = "ApiActivityPresenter";
    ApiActivityContract.View view;
    Map<String, String> query = new ArrayMap<>();
    List<DisplayObject> itemList = new ArrayList<>();

    @Override
    public void attachView(ApiActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public void makeCall(int pageCallUpdate, String upc) {
//        Dummy data
//        DisplayObject Walmart = new DisplayObject( "Walmart Super Center",
//                                                        55.00,
//                                                        34.00,
//                                                        R.drawable.walmart);
//
//        DisplayObject Target = new DisplayObject("Target",
//                                                        42.42,
//                                                        52.00,
//                                                        R.drawable.target300);
//
//        itemList.add( Walmart );
//        itemList.add( Target );
//        recycleViewAdapter.notifyDataSetChanged();

        Log.d(TAG, "makeCall: upc:" + upc);
        Log.d(TAG, "makeCall: " + query);

        query.put("query", upc);
//        query.put("query", "813516025388");
//        query.put("query", "039400019770");
        query.put("format", "json");
        query.put("apiKey", "jy3vtxwdpxva9vs8jakbf2us");
        //query.put("numItems", "25");
        query.put("start", String.valueOf(pageCallUpdate));

        RetrofitHelper.getCall(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Search>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull Search search) {

                        Log.d(TAG, "onNext: Found " + search.getNumItems());

                        if (search.getItems() != null) {
                            for (Item i : search.getItems()) {
//                            itemList.add(i);
                                Log.d(TAG, "onNext: Item name: " + i.getName());
                                Log.d(TAG, "onNext: Item sale price:" + i.getSalePrice());
                                Log.d(TAG, "onNext: Item msrp:" + i.getMsrp());
                                DisplayObject walmart = new DisplayObject(
//                                    "Walmart Super Center",
                                        i.getName(),
                                        i.getSalePrice(),
                                        34.00,
                                        R.drawable.walmart
                                );

                                itemList.add(walmart);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
//                        recycleViewAdapter.notifyDataSetChanged();
                        view.initRecyclerView( itemList );

                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
