package com.example.admin.quickmaths.model.display;

/**
 * Created by Admin on 11/11/2017.
 */

public class DisplayObject {
    String store;
    double price, distance;
    int drawableResource;

    public DisplayObject(String store, double price, double distance, int drawableResource) {
        this.store = store;
        this.price = price;
        this.distance = distance;
        this.drawableResource = drawableResource;
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public double getDistance() {
        return distance;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }
}
