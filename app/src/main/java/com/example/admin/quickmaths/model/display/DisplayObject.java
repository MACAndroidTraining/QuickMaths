package com.example.admin.quickmaths.model.display;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 11/11/2017.
 */

public class DisplayObject implements Parcelable{
    String store, product;
    String url;
    double price, distance;
    boolean onLine;

    public DisplayObject(String product, String store, double price, double distance, boolean onLine) {
        this.product = product;
        this.store = store;
        this.price = price;
        this.distance = distance;
        this.onLine = onLine;
    }

    protected DisplayObject(Parcel in) {
        store = in.readString();
        product = in.readString();
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

//    public String getLogoURL() {
//        return logoURL;
//    }

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

//    public void setLogoURL(String logoURL) {
//        this.logoURL = logoURL;
//    }

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
//        parcel.writeString(logoURL);
        parcel.writeString(product);
        parcel.writeDouble(price);
        parcel.writeDouble(distance);
        parcel.writeByte((byte) (onLine ? 1 : 0));
    }
}
