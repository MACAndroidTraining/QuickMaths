
package com.example.admin.quickmaths.model.VOD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestMarketplacePrice {

    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("sellerInfo")
    @Expose
    private String sellerInfo;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("twoThreeDayShippingRate")
    @Expose
    private Double twoThreeDayShippingRate;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;
    @SerializedName("offerType")
    @Expose
    private String offerType;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public Double getTwoThreeDayShippingRate() {
        return twoThreeDayShippingRate;
    }

    public void setTwoThreeDayShippingRate(Double twoThreeDayShippingRate) {
        this.twoThreeDayShippingRate = twoThreeDayShippingRate;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

}
