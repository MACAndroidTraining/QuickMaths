
package com.example.admin.quickmaths.model.UPCItemDB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable
{

    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("dimension")
    @Expose
    private String dimension;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("lowest_recorded_price")
    @Expose
    private Double lowestRecordedPrice;
    @SerializedName("highest_recorded_price")
    @Expose
    private Double highestRecordedPrice;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;
    @SerializedName("asin")
    @Expose
    private String asin;
    @SerializedName("elid")
    @Expose
    private String elid;
    private final static long serialVersionUID = -6687526553205168993L;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getLowestRecordedPrice() {
        return lowestRecordedPrice;
    }

    public void setLowestRecordedPrice(Double lowestRecordedPrice) {
        this.lowestRecordedPrice = lowestRecordedPrice;
    }

    public Double getHighestRecordedPrice() {
        return highestRecordedPrice;
    }

    public void setHighestRecordedPrice(Double highestRecordedPrice) {
        this.highestRecordedPrice = highestRecordedPrice;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getElid() {
        return elid;
    }

    public void setElid(String elid) {
        this.elid = elid;
    }

}
