package com.example.admin.quickmaths.data;

import android.util.Log;

import com.example.admin.quickmaths.model.UPCItemDB.SearchResult;
import com.example.admin.quickmaths.model.WalmartSearch.WalmartSearch;
import com.example.admin.quickmaths.model.bestBuy.BestBuy;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/14/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL_WALMART = "http://api.walmartlabs.com";
    public static final String BASE_URL_BEST_BUY = "https://api.bestbuy.com";
    public static final String BASE_URL_UPCDB = "https://api.upcitemdb.com/prod/trial/";

    static public Retrofit create(String url){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    static public Observable<WalmartSearch> callWalmart(Map<String, String> query){
//        Retrofit retrofit = create();
        Retrofit retrofit = create(BASE_URL_WALMART);
        RequestService service = retrofit.create(RequestService.class);
        Log.d(TAG, "callWalmart: " + query);
        return service.walmartResponseService(query);
    }

    static public Observable<BestBuy> callBestBuy(String upc, Map<String, String> query){
        Retrofit retrofit = create(BASE_URL_BEST_BUY);
        RequestService service = retrofit.create(RequestService.class);
        Log.d(TAG, "callBestBuy: " + query);
        return service.bestBuyResponseService(upc, query);
    }

    static public Observable<SearchResult> callUpcDB(Map<String, String> query){
        Retrofit retrofit = create(BASE_URL_UPCDB);
        RequestService service = retrofit.create(RequestService.class);
        Log.d(TAG, "callUpcDB: " + query);
        return service.upcDBService(query);
    }

    static public Observable<SearchResult> textSearch(Map<String, String> query){
        Retrofit retrofit = create(BASE_URL_UPCDB);
        RequestService service = retrofit.create(RequestService.class);
        Log.d(TAG, "textSearch: " + query);
        return service.upcDBSearchService(query);
    }

    public interface RequestService {
        @GET("/v1/search")
        Observable<WalmartSearch> walmartResponseService(@QueryMap Map<String, String> query);
        // http://api.walmartlabs.com/v1/search?query=014633733877&format=json&apiKey=jy3vtxwdpxva9vs8jakbf2us&start=1

        @GET("/v1/products(upc={UPC})")
        Observable<BestBuy> bestBuyResponseService(@Path("UPC") String upc, @QueryMap Map<String, String> query);
        // https://api.bestbuy.com/v1/products(upc=014633733877)?format=json&show=all&apiKey=FI0jE6GWPKhI4DNGRQmOuoiz
        // show= lets you control what is returned.
        // 'https://api.bestbuy.com/v1/products(categoryPath.name="All%20Flat-Panel%20TVs")?format=json&show=sku,name,salePrice&sort=salesRankMediumTerm.asc&apiKey=FI0jE6GWPKhI4DNGRQmOuoiz

        @GET("lookup")
        Observable<SearchResult> upcDBService(@QueryMap Map<String, String> query);
//        https://api.upcitemdb.com/prod/trial/lookup?upc=052000320169

        @GET("search")
        Observable<SearchResult> upcDBSearchService(@QueryMap Map<String, String> query);
//        https://api.upcitemdb.com/prod/trial/search?s="Gatorade"

    }
}

/*
Tried:
advanced auto parts
cvs
dicks sporting gods
eb games
gamestop
gnc
food lion
Kroger
Micro Center
O'Reilly Auto Parts
pet smart
Sam's Club
http://developer.staples.com/apis
Target
 */