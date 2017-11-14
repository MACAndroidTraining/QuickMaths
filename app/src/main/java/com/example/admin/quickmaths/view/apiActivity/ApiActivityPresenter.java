package com.example.admin.quickmaths.view.apiActivity;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.data.RetrofitHelper;
import com.example.admin.quickmaths.model.WalmartSearch.Item;
import com.example.admin.quickmaths.model.WalmartSearch.WalmartSearch;
import com.example.admin.quickmaths.model.bestBuy.BestBuy;
import com.example.admin.quickmaths.model.bestBuy.Product;
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
        Log.d(TAG, "makeCall: upc:" + upc);
        callWalmart(pageCallUpdate, upc);
        callBestBuy( upc );
    }

    private void callWalmart(int pageCallUpdate, String upc) {
        Map<String, String> query = new ArrayMap<>();
        query.put("query", upc);
        query.put("format", "json");
        query.put("apiKey", "jy3vtxwdpxva9vs8jakbf2us");
        query.put("start", String.valueOf(pageCallUpdate));

        RetrofitHelper.callWalmart(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WalmartSearch>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "Walmart onSubscribe: " + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull WalmartSearch search) {

                        Log.d(TAG, "Walmart onNext: Found " + search.getNumItems());

                        if (search.getItems() != null) {
                            for (Item i : search.getItems()) {
//                            itemList.add(i);
                                Log.d(TAG, "Walmart onNext: Item name: " + i.getName());
                                Log.d(TAG, "Walmart onNext: Item sale price:" + i.getSalePrice());
                                Log.d(TAG, "Walmart onNext: Item msrp:" + i.getMsrp());
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
                        Log.d(TAG, "Walmart onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
//                        recycleViewAdapter.notifyDataSetChanged();
                        view.initRecyclerView(itemList);

                        Log.d(TAG, "Walmart onComplete: ");
                        Log.d(TAG, " ");
                    }
                });
    }

    private void callBestBuy( String upc ) {
        // https://bestbuyapis.github.io/api-documentation/#products-api
        Map<String, String> bestBuyQuery = new ArrayMap<>();
        bestBuyQuery.put("format", "json");
        bestBuyQuery.put("show", "all");
        bestBuyQuery.put("apiKey", "FI0jE6GWPKhI4DNGRQmOuoiz");

        RetrofitHelper.callBestBuy(upc, bestBuyQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BestBuy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "Best Buy onSubscribe: ");
                    }

                    @Override
                    public void onNext(BestBuy bestBuy) {
                        Log.d(TAG, "Best Buy onNext: Found " + bestBuy.getTotal());

                        if (bestBuy.getProducts() != null) {
                            for (Product p : bestBuy.getProducts()) {
                                Log.d(TAG, "Best Buy onNext: Item name: " + p.getName());
                                Log.d(TAG, "Best Buy onNext: Item regular price:" + p.getRegularPrice());
                                Log.d(TAG, "Best Buy onNext: Item sale price:" + p.getSalePrice());
                                // TODO: 11/14/2017 also has an 'On Sale' value, could include that.
                                // TODO: 11/14/2017 and ratings

                                DisplayObject bb = new DisplayObject(
                                        p.getName(),
                                        p.getSalePrice(),
                                        34.00,
                                        R.drawable.bestbuy
                                );

                                itemList.add(bb);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Best Buy onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "Best Buy onComplete: ");
                        Log.d(TAG, "  ");
                        view.initRecyclerView(itemList);
                    }
                });
        // https://bestbuyapis.github.io/api-documentation/#stores-api
        // could be used for distance to nearest store.
    }
}
