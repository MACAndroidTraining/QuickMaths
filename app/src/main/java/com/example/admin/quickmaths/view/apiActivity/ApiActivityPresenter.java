package com.example.admin.quickmaths.view.apiActivity;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.data.RetrofitHelper;
import com.example.admin.quickmaths.model.UPCItemDB.Offer;
import com.example.admin.quickmaths.model.UPCItemDB.SearchResult;
import com.example.admin.quickmaths.model.WalmartSearch.Item;
import com.example.admin.quickmaths.model.WalmartSearch.WalmartSearch;
import com.example.admin.quickmaths.model.bestBuy.BestBuy;
import com.example.admin.quickmaths.model.bestBuy.Product;
import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.utils.SignedRequestsHelper;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
        callBestBuy(upc);
//        callUpcDB(upc);
        callAmazon(upc);
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
                                        i.getName(),
                                        "walmart",
                                        "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg",
                                        i.getSalePrice(),
                                        34.00,
                                        false
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
                        view.mergeSort(itemList);
                        view.initRecyclerView(itemList);

                        Log.d(TAG, "Walmart onComplete: ");
                        Log.d(TAG, " ");
                    }
                });
    }

    private void callBestBuy(String upc) {
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
                                        "best buy",
                                        "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg",
                                        p.getSalePrice(),
                                        34.00,
                                        false
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
                        view.mergeSort(itemList);
                        view.initRecyclerView(itemList);
                    }
                });
        // https://bestbuyapis.github.io/api-documentation/#stores-api
        // could be used for distance to nearest store.
    }

    private void callUpcDB(String upc) {
        Map<String, String> query = new ArrayMap<>();
        query.put("upc", upc);

        RetrofitHelper.callUpcDB(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SearchResult>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "UPC DB onSubscribe: " + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull SearchResult search) {

                        Log.d(TAG, "UPC DB onNext: Found " + search.getItems().get(0).getOffers().size());

                        if (search.getTotal() > 0) {
                            for (Offer i : search.getItems().get(0).getOffers()) {

                                if( i.getMerchant().equals("") )
                                    break;

                                Log.d(TAG, "UPC DB onNext: Merchant name: " + i.getMerchant());
                                Log.d(TAG, "UPC DB onNext: Domain name: " + i.getDomain());
                                Log.d(TAG, "UPC DB onNext: Item name: " + i.getTitle());
                                Log.d(TAG, "UPC DB onNext: Item sale price:" + i.getPrice());
                                Log.d(TAG, "UPC DB onNext: ");

                                boolean onLine = (i.getMerchant().contains(".com"));

                                if( i.getMerchant().equals("Wal-Mart.com") )
                                    onLine = false;
                                else if( i.getMerchant().equals("GameFly") ||
                                        i.getMerchant().equals("TigerDirect") )
                                    onLine = true;

                                DisplayObject upcItem = new DisplayObject(
                                        i.getTitle(),
                                        i.getMerchant(),
                                        null,
                                        i.getPrice(),
                                        34.00,
                                        onLine
                                );

                                itemList.add(upcItem);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "UPC DB onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
//                        recycleViewAdapter.notifyDataSetChanged();
                        view.mergeSort(itemList);
                        view.initRecyclerView(itemList);

                        Log.d(TAG, "UPC DB onComplete: ");
                        Log.d(TAG, " ");
                    }
                });
    }

    private void callAmazon(final String upc) {

        final Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                final String AWS_ACCESS_KEY_ID = "AKIAJS3W7HDOJLZ7XYTQ";
                final String AWS_SECRET_KEY = "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";
                final String ENDPOINT = "ecs.amazonaws.com";
                final String ITEM_ID = upc;

                SignedRequestsHelper helper;
                try {
                    helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                Map<String, String> params = new HashMap<String, String>();
                params.put("Service", "AWSECommerceService");
                params.put("Version", "2009-03-31");
                params.put("Operation", "ItemLookup");
                params.put("ItemId", ITEM_ID);
                params.put("ResponseGroup", "Medium");
                params.put("AssociateTag", "myers831-20");
                params.put("IdType", "UPC");
                params.put("SearchIndex", "All");

                String requestUrl = helper.sign(params);

                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(requestUrl);

                    Node priceNode = doc.getElementsByTagName("FormattedPrice").item(0);
                    Node titleNode = doc.getElementsByTagName("Title").item(0);

                    if( titleNode != null ) {
                        System.out.println(titleNode.getTextContent());
                        System.out.println(priceNode.getTextContent());
                        DisplayObject amazon = new DisplayObject(
                                titleNode.getTextContent(),
                                "amazon",
                                "http://freelogo2016cdn.b-cdn.net/wp-content/uploads/2016/12/amazon_logo.png",
                                Double.parseDouble(priceNode.getTextContent().substring(1)),
                                0,
                                true
                        );

                        itemList.add(amazon);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
        t.start();
        view.mergeSort(itemList);
        view.initRecyclerView(itemList);
    }
}
