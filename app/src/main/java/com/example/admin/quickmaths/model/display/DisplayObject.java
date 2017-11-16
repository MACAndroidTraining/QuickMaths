package com.example.admin.quickmaths.model.display;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 11/11/2017.
 */

public class DisplayObject implements Parcelable{
    String store;
    String logoURL;
    String product;
    String productDescription;
    double price, distance;
    boolean onLine;

    public DisplayObject(String product,String productDescription, String store, String logoURL, double price, double distance, boolean onLine) {
        this.product = product;
        this.productDescription = productDescription;
        this.store = store;
        this.logoURL = logoURL;
        this.price = price;
        this.distance = distance;
        this.onLine = onLine;
    }

    protected DisplayObject(Parcel in) {
        store = in.readString();
        logoURL = in.readString();
        product = in.readString();
        productDescription = in.readString();
        price = in.readDouble();
        distance = in.readDouble();
        onLine = in.readByte() != 0;
    }

    public static final Creator<DisplayObject> CREATOR = new Creator<DisplayObject>() {
        @Override
        public DisplayObject createFromParcel(Parcel in) {
            return new DisplayObject(in);
        }

        @Override
        public DisplayObject[] newArray(int size) {
            return new DisplayObject[size];
        }
    };

    public String getStore() {
        return store;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public double getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }

    public String getProduct() {
        return product;
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(store);
        parcel.writeString(logoURL);
        parcel.writeString(product);
        parcel.writeString(productDescription);
        parcel.writeDouble(price);
        parcel.writeDouble(distance);
        parcel.writeByte((byte) (onLine ? 1 : 0));
    }
}
