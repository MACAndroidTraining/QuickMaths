
package com.example.admin.quickmaths.model.Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("parentItemId")
    @Expose
    private Integer parentItemId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msrp")
    @Expose
    private Double msrp;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("customerRating")
    @Expose
    private String customerRating;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;
    @SerializedName("giftOptions")
    @Expose
    private GiftOptions giftOptions;
    @SerializedName("imageEntities")
    @Expose
    private List<ImageEntity> imageEntities = null;
    @SerializedName("offerType")
    @Expose
    private String offerType;
    @SerializedName("isTwoDayShippingEligible")
    @Expose
    private Boolean isTwoDayShippingEligible;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public Boolean getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    public String getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Boolean getIsTwoDayShippingEligible() {
        return isTwoDayShippingEligible;
    }

    public void setIsTwoDayShippingEligible(Boolean isTwoDayShippingEligible) {
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
    }

}
