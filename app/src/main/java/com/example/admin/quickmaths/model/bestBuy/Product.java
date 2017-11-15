
package com.example.admin.quickmaths.model.bestBuy;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable
{

    @SerializedName("sku")
    @Expose
    private Integer sku;
    @SerializedName("score")
    @Expose
    private Object score;
    @SerializedName("productId")
    @Expose
    private Long productId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("new")
    @Expose
    private Boolean _new;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("lowPriceGuarantee")
    @Expose
    private Boolean lowPriceGuarantee;
    @SerializedName("activeUpdateDate")
    @Expose
    private String activeUpdateDate;
    @SerializedName("regularPrice")
    @Expose
    private Double regularPrice;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;
    @SerializedName("onSale")
    @Expose
    private Boolean onSale;
    @SerializedName("planPrice")
    @Expose
    private Object planPrice;
    @SerializedName("priceWithPlan")
    @Expose
    @Valid
    private List<Object> priceWithPlan = null;
    @SerializedName("contracts")
    @Expose
    @Valid
    private List<Object> contracts = null;
    @SerializedName("priceRestriction")
    @Expose
    private Object priceRestriction;
    @SerializedName("priceUpdateDate")
    @Expose
    private String priceUpdateDate;
    @SerializedName("digital")
    @Expose
    private Boolean digital;
    @SerializedName("preowned")
    @Expose
    private Boolean preowned;
    @SerializedName("carriers")
    @Expose
    @Valid
    private List<Object> carriers = null;
    @SerializedName("planFeatures")
    @Expose
    @Valid
    private List<Object> planFeatures = null;
    @SerializedName("devices")
    @Expose
    @Valid
    private List<Object> devices = null;
    @SerializedName("carrierPlans")
    @Expose
    @Valid
    private List<Object> carrierPlans = null;
    @SerializedName("technologyCode")
    @Expose
    private Object technologyCode;
    @SerializedName("carrierModelNumber")
    @Expose
    private Object carrierModelNumber;
    @SerializedName("earlyTerminationFees")
    @Expose
    @Valid
    private List<Object> earlyTerminationFees = null;
    @SerializedName("monthlyRecurringCharge")
    @Expose
    private String monthlyRecurringCharge;
    @SerializedName("monthlyRecurringChargeGrandTotal")
    @Expose
    private String monthlyRecurringChargeGrandTotal;
    @SerializedName("activationCharge")
    @Expose
    private String activationCharge;
    @SerializedName("minutePrice")
    @Expose
    private String minutePrice;
    @SerializedName("planCategory")
    @Expose
    private Object planCategory;
    @SerializedName("planType")
    @Expose
    private Object planType;
    @SerializedName("familyIndividualCode")
    @Expose
    private Object familyIndividualCode;
    @SerializedName("validFrom")
    @Expose
    private Object validFrom;
    @SerializedName("validUntil")
    @Expose
    private Object validUntil;
    @SerializedName("carrierPlan")
    @Expose
    private Object carrierPlan;
    @SerializedName("outletCenter")
    @Expose
    private Object outletCenter;
    @SerializedName("secondaryMarket")
    @Expose
    private Object secondaryMarket;
    @SerializedName("frequentlyPurchasedWith")
    @Expose
    @Valid
    private List<Object> frequentlyPurchasedWith = null;
    @SerializedName("accessories")
    @Expose
    @Valid
    private List<Object> accessories = null;
    @SerializedName("relatedProducts")
    @Expose
    @Valid
    private List<RelatedProduct> relatedProducts = null;
    @SerializedName("techSupportPlans")
    @Expose
    @Valid
    private List<Object> techSupportPlans = null;
    @SerializedName("crossSell")
    @Expose
    @Valid
    private List<Object> crossSell = null;
    @SerializedName("salesRankShortTerm")
    @Expose
    private Integer salesRankShortTerm;
    @SerializedName("salesRankMediumTerm")
    @Expose
    private Integer salesRankMediumTerm;
    @SerializedName("salesRankLongTerm")
    @Expose
    private Integer salesRankLongTerm;
    @SerializedName("bestSellingRank")
    @Expose
    private Integer bestSellingRank;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("spin360Url")
    @Expose
    private Object spin360Url;
    @SerializedName("mobileUrl")
    @Expose
    private String mobileUrl;
    @SerializedName("affiliateUrl")
    @Expose
    private Object affiliateUrl;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private Object affiliateAddToCartUrl;
    @SerializedName("linkShareAffiliateUrl")
    @Expose
    private String linkShareAffiliateUrl;
    @SerializedName("linkShareAffiliateAddToCartUrl")
    @Expose
    private String linkShareAffiliateAddToCartUrl;
    @SerializedName("search")
    @Expose
    private Object search;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("productTemplate")
    @Expose
    private String productTemplate;
    @SerializedName("categoryPath")
    @Expose
    @Valid
    private List<CategoryPath> categoryPath = null;
    @SerializedName("alternateCategories")
    @Expose
    @Valid
    private List<AlternateCategory> alternateCategories = null;
    @SerializedName("lists")
    @Expose
    @Valid
    private List<Object> lists = null;
    @SerializedName("customerReviewCount")
    @Expose
    private Integer customerReviewCount;
    @SerializedName("customerReviewAverage")
    @Expose
    private Double customerReviewAverage;
    @SerializedName("customerTopRated")
    @Expose
    private Boolean customerTopRated;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("freeShipping")
    @Expose
    private Boolean freeShipping;
    @SerializedName("freeShippingEligible")
    @Expose
    private Boolean freeShippingEligible;
    @SerializedName("inStoreAvailability")
    @Expose
    private Boolean inStoreAvailability;
    @SerializedName("inStoreAvailabilityText")
    @Expose
    private String inStoreAvailabilityText;
    @SerializedName("inStoreAvailabilityTextHtml")
    @Expose
    private String inStoreAvailabilityTextHtml;
    @SerializedName("inStoreAvailabilityUpdateDate")
    @Expose
    private String inStoreAvailabilityUpdateDate;
    @SerializedName("itemUpdateDate")
    @Expose
    private String itemUpdateDate;
    @SerializedName("onlineAvailability")
    @Expose
    private Boolean onlineAvailability;
    @SerializedName("onlineAvailabilityText")
    @Expose
    private String onlineAvailabilityText;
    @SerializedName("onlineAvailabilityTextHtml")
    @Expose
    private String onlineAvailabilityTextHtml;
    @SerializedName("onlineAvailabilityUpdateDate")
    @Expose
    private String onlineAvailabilityUpdateDate;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("shippingCost")
    @Expose
    private Integer shippingCost;
    @SerializedName("shipping")
    @Expose
    @Valid
    private List<Shipping> shipping = null;
    @SerializedName("shippingLevelsOfService")
    @Expose
    @Valid
    private List<ShippingLevelsOfService> shippingLevelsOfService = null;
    @SerializedName("specialOrder")
    @Expose
    private Boolean specialOrder;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("shortDescriptionHtml")
    @Expose
    private String shortDescriptionHtml;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("subclass")
    @Expose
    private String subclass;
    @SerializedName("subclassId")
    @Expose
    private Integer subclassId;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("departmentId")
    @Expose
    private Integer departmentId;
    @SerializedName("bestBuyItemId")
    @Expose
    private String bestBuyItemId;
    @SerializedName("protectionPlanTerm")
    @Expose
    private String protectionPlanTerm;
    @SerializedName("protectionPlanType")
    @Expose
    private Object protectionPlanType;
    @SerializedName("protectionPlanLowPrice")
    @Expose
    private String protectionPlanLowPrice;
    @SerializedName("protectionPlanHighPrice")
    @Expose
    private String protectionPlanHighPrice;
    @SerializedName("buybackPlans")
    @Expose
    @Valid
    private List<Object> buybackPlans = null;
    @SerializedName("protectionPlans")
    @Expose
    @Valid
    private List<Object> protectionPlans = null;
    @SerializedName("protectionPlanDetails")
    @Expose
    @Valid
    private List<Object> protectionPlanDetails = null;
    @SerializedName("productFamilies")
    @Expose
    @Valid
    private List<Object> productFamilies = null;
    @SerializedName("productVariations")
    @Expose
    @Valid
    private List<ProductVariation> productVariations = null;
    @SerializedName("aspectRatio")
    @Expose
    private Object aspectRatio;
    @SerializedName("screenFormat")
    @Expose
    private Object screenFormat;
    @SerializedName("lengthInMinutes")
    @Expose
    private Object lengthInMinutes;
    @SerializedName("mpaaRating")
    @Expose
    private Object mpaaRating;
    @SerializedName("plot")
    @Expose
    private Object plot;
    @SerializedName("plotHtml")
    @Expose
    private Object plotHtml;
    @SerializedName("studio")
    @Expose
    private Object studio;
    @SerializedName("theatricalReleaseDate")
    @Expose
    private Object theatricalReleaseDate;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("largeFrontImage")
    @Expose
    private String largeFrontImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("alternateViewsImage")
    @Expose
    private String alternateViewsImage;
    @SerializedName("angleImage")
    @Expose
    private Object angleImage;
    @SerializedName("backViewImage")
    @Expose
    private Object backViewImage;
    @SerializedName("energyGuideImage")
    @Expose
    private Object energyGuideImage;
    @SerializedName("leftViewImage")
    @Expose
    private Object leftViewImage;
    @SerializedName("accessoriesImage")
    @Expose
    private Object accessoriesImage;
    @SerializedName("remoteControlImage")
    @Expose
    private Object remoteControlImage;
    @SerializedName("rightViewImage")
    @Expose
    private Object rightViewImage;
    @SerializedName("topViewImage")
    @Expose
    private Object topViewImage;
    @SerializedName("albumTitle")
    @Expose
    private String albumTitle;
    @SerializedName("artistName")
    @Expose
    private Object artistName;
    @SerializedName("artistId")
    @Expose
    private Object artistId;
    @SerializedName("originalReleaseDate")
    @Expose
    private Object originalReleaseDate;
    @SerializedName("parentalAdvisory")
    @Expose
    private Object parentalAdvisory;
    @SerializedName("mediaCount")
    @Expose
    private Object mediaCount;
    @SerializedName("monoStereo")
    @Expose
    private Object monoStereo;
    @SerializedName("studioLive")
    @Expose
    private Object studioLive;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("inStorePickup")
    @Expose
    private Boolean inStorePickup;
    @SerializedName("friendsAndFamilyPickup")
    @Expose
    private Boolean friendsAndFamilyPickup;
    @SerializedName("homeDelivery")
    @Expose
    private Boolean homeDelivery;
    @SerializedName("quantityLimit")
    @Expose
    private Integer quantityLimit;
    @SerializedName("fulfilledBy")
    @Expose
    private String fulfilledBy;
    @SerializedName("members")
    @Expose
    @Valid
    private List<Object> members = null;
    @SerializedName("bundledIn")
    @Expose
    @Valid
    private List<Object> bundledIn = null;
    @SerializedName("albumLabel")
    @Expose
    private Object albumLabel;
    @SerializedName("genre")
    @Expose
    private Object genre;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("depth")
    @Expose
    private Object depth;
    @SerializedName("dollarSavings")
    @Expose
    private Integer dollarSavings;
    @SerializedName("percentSavings")
    @Expose
    private String percentSavings;
    @SerializedName("tradeInValue")
    @Expose
    private String tradeInValue;
    @SerializedName("height")
    @Expose
    private Object height;
    @SerializedName("orderable")
    @Expose
    private String orderable;
    @SerializedName("weight")
    @Expose
    private Object weight;
    @SerializedName("shippingWeight")
    @Expose
    private Double shippingWeight;
    @SerializedName("width")
    @Expose
    private Object width;
    @SerializedName("warrantyLabor")
    @Expose
    private String warrantyLabor;
    @SerializedName("warrantyParts")
    @Expose
    private String warrantyParts;
    @SerializedName("softwareAge")
    @Expose
    private Object softwareAge;
    @SerializedName("softwareGrade")
    @Expose
    private Object softwareGrade;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("numberOfPlayers")
    @Expose
    private Object numberOfPlayers;
    @SerializedName("softwareNumberOfPlayers")
    @Expose
    private Object softwareNumberOfPlayers;
    @SerializedName("esrbRating")
    @Expose
    private String esrbRating;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("longDescriptionHtml")
    @Expose
    private String longDescriptionHtml;
    @SerializedName("cast")
    @Expose
    @Valid
    private List<Object> cast = null;
    @SerializedName("crew")
    @Expose
    @Valid
    private List<Object> crew = null;
    @SerializedName("details")
    @Expose
    @Valid
    private List<Detail> details = null;
    @SerializedName("includedItemList")
    @Expose
    @Valid
    private List<IncludedItemList> includedItemList = null;
    @SerializedName("features")
    @Expose
    @Valid
    private List<Feature> features = null;
    @SerializedName("offers")
    @Expose
    @Valid
    private List<Object> offers = null;
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @SerializedName("listingId")
    @Expose
    private Object listingId;
    @SerializedName("sellerId")
    @Expose
    private Object sellerId;
    @SerializedName("shippingRestrictions")
    @Expose
    private Object shippingRestrictions;
    @SerializedName("discs")
    @Expose
    @Valid
    private List<Object> discs = null;
    @SerializedName("commerceSku")
    @Expose
    private Integer commerceSku;
    public final static Parcelable.Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;

    protected Product(Parcel in) {
        this.sku = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.score = ((Object) in.readValue((Object.class.getClassLoader())));
        this.productId = ((Long) in.readValue((Long.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this._new = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lowPriceGuarantee = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.activeUpdateDate = ((String) in.readValue((String.class.getClassLoader())));
        this.regularPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.salePrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.clearance = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.onSale = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.planPrice = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.priceWithPlan, (java.lang.Object.class.getClassLoader()));
        in.readList(this.contracts, (java.lang.Object.class.getClassLoader()));
        this.priceRestriction = ((Object) in.readValue((Object.class.getClassLoader())));
        this.priceUpdateDate = ((String) in.readValue((String.class.getClassLoader())));
        this.digital = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.preowned = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.carriers, (java.lang.Object.class.getClassLoader()));
        in.readList(this.planFeatures, (java.lang.Object.class.getClassLoader()));
        in.readList(this.devices, (java.lang.Object.class.getClassLoader()));
        in.readList(this.carrierPlans, (java.lang.Object.class.getClassLoader()));
        this.technologyCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.carrierModelNumber = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.earlyTerminationFees, (java.lang.Object.class.getClassLoader()));
        this.monthlyRecurringCharge = ((String) in.readValue((String.class.getClassLoader())));
        this.monthlyRecurringChargeGrandTotal = ((String) in.readValue((String.class.getClassLoader())));
        this.activationCharge = ((String) in.readValue((String.class.getClassLoader())));
        this.minutePrice = ((String) in.readValue((String.class.getClassLoader())));
        this.planCategory = ((Object) in.readValue((Object.class.getClassLoader())));
        this.planType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.familyIndividualCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.validFrom = ((Object) in.readValue((Object.class.getClassLoader())));
        this.validUntil = ((Object) in.readValue((Object.class.getClassLoader())));
        this.carrierPlan = ((Object) in.readValue((Object.class.getClassLoader())));
        this.outletCenter = ((Object) in.readValue((Object.class.getClassLoader())));
        this.secondaryMarket = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.frequentlyPurchasedWith, (java.lang.Object.class.getClassLoader()));
        in.readList(this.accessories, (java.lang.Object.class.getClassLoader()));
        in.readList(this.relatedProducts, (com.example.admin.quickmaths.model.bestBuy.RelatedProduct.class.getClassLoader()));
        in.readList(this.techSupportPlans, (java.lang.Object.class.getClassLoader()));
        in.readList(this.crossSell, (java.lang.Object.class.getClassLoader()));
        this.salesRankShortTerm = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.salesRankMediumTerm = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.salesRankLongTerm = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bestSellingRank = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.spin360Url = ((Object) in.readValue((Object.class.getClassLoader())));
        this.mobileUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.affiliateUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.addToCartUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.affiliateAddToCartUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.linkShareAffiliateUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.linkShareAffiliateAddToCartUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.search = ((Object) in.readValue((Object.class.getClassLoader())));
        this.upc = ((String) in.readValue((String.class.getClassLoader())));
        this.productTemplate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.categoryPath, (com.example.admin.quickmaths.model.bestBuy.CategoryPath.class.getClassLoader()));
        in.readList(this.alternateCategories, (com.example.admin.quickmaths.model.bestBuy.AlternateCategory.class.getClassLoader()));
        in.readList(this.lists, (java.lang.Object.class.getClassLoader()));
        this.customerReviewCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.customerReviewAverage = ((Double) in.readValue((Double.class.getClassLoader())));
        this.customerTopRated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.format = ((String) in.readValue((String.class.getClassLoader())));
        this.freeShipping = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.freeShippingEligible = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.inStoreAvailability = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.inStoreAvailabilityText = ((String) in.readValue((String.class.getClassLoader())));
        this.inStoreAvailabilityTextHtml = ((String) in.readValue((String.class.getClassLoader())));
        this.inStoreAvailabilityUpdateDate = ((String) in.readValue((String.class.getClassLoader())));
        this.itemUpdateDate = ((String) in.readValue((String.class.getClassLoader())));
        this.onlineAvailability = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.onlineAvailabilityText = ((String) in.readValue((String.class.getClassLoader())));
        this.onlineAvailabilityTextHtml = ((String) in.readValue((String.class.getClassLoader())));
        this.onlineAvailabilityUpdateDate = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingCost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.shipping, (com.example.admin.quickmaths.model.bestBuy.Shipping.class.getClassLoader()));
        in.readList(this.shippingLevelsOfService, (com.example.admin.quickmaths.model.bestBuy.ShippingLevelsOfService.class.getClassLoader()));
        this.specialOrder = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.shortDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.shortDescriptionHtml = ((String) in.readValue((String.class.getClassLoader())));
        this._class = ((String) in.readValue((String.class.getClassLoader())));
        this.classId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.subclass = ((String) in.readValue((String.class.getClassLoader())));
        this.subclassId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.department = ((String) in.readValue((String.class.getClassLoader())));
        this.departmentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bestBuyItemId = ((String) in.readValue((String.class.getClassLoader())));
        this.protectionPlanTerm = ((String) in.readValue((String.class.getClassLoader())));
        this.protectionPlanType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.protectionPlanLowPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.protectionPlanHighPrice = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.buybackPlans, (java.lang.Object.class.getClassLoader()));
        in.readList(this.protectionPlans, (java.lang.Object.class.getClassLoader()));
        in.readList(this.protectionPlanDetails, (java.lang.Object.class.getClassLoader()));
        in.readList(this.productFamilies, (java.lang.Object.class.getClassLoader()));
        in.readList(this.productVariations, (com.example.admin.quickmaths.model.bestBuy.ProductVariation.class.getClassLoader()));
        this.aspectRatio = ((Object) in.readValue((Object.class.getClassLoader())));
        this.screenFormat = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lengthInMinutes = ((Object) in.readValue((Object.class.getClassLoader())));
        this.mpaaRating = ((Object) in.readValue((Object.class.getClassLoader())));
        this.plot = ((Object) in.readValue((Object.class.getClassLoader())));
        this.plotHtml = ((Object) in.readValue((Object.class.getClassLoader())));
        this.studio = ((Object) in.readValue((Object.class.getClassLoader())));
        this.theatricalReleaseDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
        this.manufacturer = ((String) in.readValue((String.class.getClassLoader())));
        this.modelNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.largeFrontImage = ((String) in.readValue((String.class.getClassLoader())));
        this.mediumImage = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnailImage = ((String) in.readValue((String.class.getClassLoader())));
        this.largeImage = ((String) in.readValue((String.class.getClassLoader())));
        this.alternateViewsImage = ((String) in.readValue((String.class.getClassLoader())));
        this.angleImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.backViewImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.energyGuideImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.leftViewImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.accessoriesImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.remoteControlImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.rightViewImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.topViewImage = ((Object) in.readValue((Object.class.getClassLoader())));
        this.albumTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.artistName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.artistId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.originalReleaseDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.parentalAdvisory = ((Object) in.readValue((Object.class.getClassLoader())));
        this.mediaCount = ((Object) in.readValue((Object.class.getClassLoader())));
        this.monoStereo = ((Object) in.readValue((Object.class.getClassLoader())));
        this.studioLive = ((Object) in.readValue((Object.class.getClassLoader())));
        this.condition = ((String) in.readValue((String.class.getClassLoader())));
        this.inStorePickup = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.friendsAndFamilyPickup = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.homeDelivery = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.quantityLimit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fulfilledBy = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.members, (java.lang.Object.class.getClassLoader()));
        in.readList(this.bundledIn, (java.lang.Object.class.getClassLoader()));
        this.albumLabel = ((Object) in.readValue((Object.class.getClassLoader())));
        this.genre = ((Object) in.readValue((Object.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.depth = ((Object) in.readValue((Object.class.getClassLoader())));
        this.dollarSavings = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.percentSavings = ((String) in.readValue((String.class.getClassLoader())));
        this.tradeInValue = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Object) in.readValue((Object.class.getClassLoader())));
        this.orderable = ((String) in.readValue((String.class.getClassLoader())));
        this.weight = ((Object) in.readValue((Object.class.getClassLoader())));
        this.shippingWeight = ((Double) in.readValue((Double.class.getClassLoader())));
        this.width = ((Object) in.readValue((Object.class.getClassLoader())));
        this.warrantyLabor = ((String) in.readValue((String.class.getClassLoader())));
        this.warrantyParts = ((String) in.readValue((String.class.getClassLoader())));
        this.softwareAge = ((Object) in.readValue((Object.class.getClassLoader())));
        this.softwareGrade = ((Object) in.readValue((Object.class.getClassLoader())));
        this.platform = ((String) in.readValue((String.class.getClassLoader())));
        this.numberOfPlayers = ((Object) in.readValue((Object.class.getClassLoader())));
        this.softwareNumberOfPlayers = ((Object) in.readValue((Object.class.getClassLoader())));
        this.esrbRating = ((String) in.readValue((String.class.getClassLoader())));
        this.longDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.longDescriptionHtml = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.cast, (java.lang.Object.class.getClassLoader()));
        in.readList(this.crew, (java.lang.Object.class.getClassLoader()));
        in.readList(this.details, (com.example.admin.quickmaths.model.bestBuy.Detail.class.getClassLoader()));
        in.readList(this.includedItemList, (com.example.admin.quickmaths.model.bestBuy.IncludedItemList.class.getClassLoader()));
        in.readList(this.features, (com.example.admin.quickmaths.model.bestBuy.Feature.class.getClassLoader()));
        in.readList(this.offers, (java.lang.Object.class.getClassLoader()));
        this.marketplace = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.listingId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.sellerId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.shippingRestrictions = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.discs, (java.lang.Object.class.getClassLoader()));
        this.commerceSku = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Product() {
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getNew() {
        return _new;
    }

    public void setNew(Boolean _new) {
        this._new = _new;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getLowPriceGuarantee() {
        return lowPriceGuarantee;
    }

    public void setLowPriceGuarantee(Boolean lowPriceGuarantee) {
        this.lowPriceGuarantee = lowPriceGuarantee;
    }

    public String getActiveUpdateDate() {
        return activeUpdateDate;
    }

    public void setActiveUpdateDate(String activeUpdateDate) {
        this.activeUpdateDate = activeUpdateDate;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Object getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(Object planPrice) {
        this.planPrice = planPrice;
    }

    public List<Object> getPriceWithPlan() {
        return priceWithPlan;
    }

    public void setPriceWithPlan(List<Object> priceWithPlan) {
        this.priceWithPlan = priceWithPlan;
    }

    public List<Object> getContracts() {
        return contracts;
    }

    public void setContracts(List<Object> contracts) {
        this.contracts = contracts;
    }

    public Object getPriceRestriction() {
        return priceRestriction;
    }

    public void setPriceRestriction(Object priceRestriction) {
        this.priceRestriction = priceRestriction;
    }

    public String getPriceUpdateDate() {
        return priceUpdateDate;
    }

    public void setPriceUpdateDate(String priceUpdateDate) {
        this.priceUpdateDate = priceUpdateDate;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public Boolean getPreowned() {
        return preowned;
    }

    public void setPreowned(Boolean preowned) {
        this.preowned = preowned;
    }

    public List<Object> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Object> carriers) {
        this.carriers = carriers;
    }

    public List<Object> getPlanFeatures() {
        return planFeatures;
    }

    public void setPlanFeatures(List<Object> planFeatures) {
        this.planFeatures = planFeatures;
    }

    public List<Object> getDevices() {
        return devices;
    }

    public void setDevices(List<Object> devices) {
        this.devices = devices;
    }

    public List<Object> getCarrierPlans() {
        return carrierPlans;
    }

    public void setCarrierPlans(List<Object> carrierPlans) {
        this.carrierPlans = carrierPlans;
    }

    public Object getTechnologyCode() {
        return technologyCode;
    }

    public void setTechnologyCode(Object technologyCode) {
        this.technologyCode = technologyCode;
    }

    public Object getCarrierModelNumber() {
        return carrierModelNumber;
    }

    public void setCarrierModelNumber(Object carrierModelNumber) {
        this.carrierModelNumber = carrierModelNumber;
    }

    public List<Object> getEarlyTerminationFees() {
        return earlyTerminationFees;
    }

    public void setEarlyTerminationFees(List<Object> earlyTerminationFees) {
        this.earlyTerminationFees = earlyTerminationFees;
    }

    public String getMonthlyRecurringCharge() {
        return monthlyRecurringCharge;
    }

    public void setMonthlyRecurringCharge(String monthlyRecurringCharge) {
        this.monthlyRecurringCharge = monthlyRecurringCharge;
    }

    public String getMonthlyRecurringChargeGrandTotal() {
        return monthlyRecurringChargeGrandTotal;
    }

    public void setMonthlyRecurringChargeGrandTotal(String monthlyRecurringChargeGrandTotal) {
        this.monthlyRecurringChargeGrandTotal = monthlyRecurringChargeGrandTotal;
    }

    public String getActivationCharge() {
        return activationCharge;
    }

    public void setActivationCharge(String activationCharge) {
        this.activationCharge = activationCharge;
    }

    public String getMinutePrice() {
        return minutePrice;
    }

    public void setMinutePrice(String minutePrice) {
        this.minutePrice = minutePrice;
    }

    public Object getPlanCategory() {
        return planCategory;
    }

    public void setPlanCategory(Object planCategory) {
        this.planCategory = planCategory;
    }

    public Object getPlanType() {
        return planType;
    }

    public void setPlanType(Object planType) {
        this.planType = planType;
    }

    public Object getFamilyIndividualCode() {
        return familyIndividualCode;
    }

    public void setFamilyIndividualCode(Object familyIndividualCode) {
        this.familyIndividualCode = familyIndividualCode;
    }

    public Object getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Object validFrom) {
        this.validFrom = validFrom;
    }

    public Object getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Object validUntil) {
        this.validUntil = validUntil;
    }

    public Object getCarrierPlan() {
        return carrierPlan;
    }

    public void setCarrierPlan(Object carrierPlan) {
        this.carrierPlan = carrierPlan;
    }

    public Object getOutletCenter() {
        return outletCenter;
    }

    public void setOutletCenter(Object outletCenter) {
        this.outletCenter = outletCenter;
    }

    public Object getSecondaryMarket() {
        return secondaryMarket;
    }

    public void setSecondaryMarket(Object secondaryMarket) {
        this.secondaryMarket = secondaryMarket;
    }

    public List<Object> getFrequentlyPurchasedWith() {
        return frequentlyPurchasedWith;
    }

    public void setFrequentlyPurchasedWith(List<Object> frequentlyPurchasedWith) {
        this.frequentlyPurchasedWith = frequentlyPurchasedWith;
    }

    public List<Object> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Object> accessories) {
        this.accessories = accessories;
    }

    public List<RelatedProduct> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<RelatedProduct> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public List<Object> getTechSupportPlans() {
        return techSupportPlans;
    }

    public void setTechSupportPlans(List<Object> techSupportPlans) {
        this.techSupportPlans = techSupportPlans;
    }

    public List<Object> getCrossSell() {
        return crossSell;
    }

    public void setCrossSell(List<Object> crossSell) {
        this.crossSell = crossSell;
    }

    public Integer getSalesRankShortTerm() {
        return salesRankShortTerm;
    }

    public void setSalesRankShortTerm(Integer salesRankShortTerm) {
        this.salesRankShortTerm = salesRankShortTerm;
    }

    public Integer getSalesRankMediumTerm() {
        return salesRankMediumTerm;
    }

    public void setSalesRankMediumTerm(Integer salesRankMediumTerm) {
        this.salesRankMediumTerm = salesRankMediumTerm;
    }

    public Integer getSalesRankLongTerm() {
        return salesRankLongTerm;
    }

    public void setSalesRankLongTerm(Integer salesRankLongTerm) {
        this.salesRankLongTerm = salesRankLongTerm;
    }

    public Integer getBestSellingRank() {
        return bestSellingRank;
    }

    public void setBestSellingRank(Integer bestSellingRank) {
        this.bestSellingRank = bestSellingRank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getSpin360Url() {
        return spin360Url;
    }

    public void setSpin360Url(Object spin360Url) {
        this.spin360Url = spin360Url;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public Object getAffiliateUrl() {
        return affiliateUrl;
    }

    public void setAffiliateUrl(Object affiliateUrl) {
        this.affiliateUrl = affiliateUrl;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public Object getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(Object affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public String getLinkShareAffiliateUrl() {
        return linkShareAffiliateUrl;
    }

    public void setLinkShareAffiliateUrl(String linkShareAffiliateUrl) {
        this.linkShareAffiliateUrl = linkShareAffiliateUrl;
    }

    public String getLinkShareAffiliateAddToCartUrl() {
        return linkShareAffiliateAddToCartUrl;
    }

    public void setLinkShareAffiliateAddToCartUrl(String linkShareAffiliateAddToCartUrl) {
        this.linkShareAffiliateAddToCartUrl = linkShareAffiliateAddToCartUrl;
    }

    public Object getSearch() {
        return search;
    }

    public void setSearch(Object search) {
        this.search = search;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductTemplate() {
        return productTemplate;
    }

    public void setProductTemplate(String productTemplate) {
        this.productTemplate = productTemplate;
    }

    public List<CategoryPath> getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(List<CategoryPath> categoryPath) {
        this.categoryPath = categoryPath;
    }

    public List<AlternateCategory> getAlternateCategories() {
        return alternateCategories;
    }

    public void setAlternateCategories(List<AlternateCategory> alternateCategories) {
        this.alternateCategories = alternateCategories;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Integer getCustomerReviewCount() {
        return customerReviewCount;
    }

    public void setCustomerReviewCount(Integer customerReviewCount) {
        this.customerReviewCount = customerReviewCount;
    }

    public Double getCustomerReviewAverage() {
        return customerReviewAverage;
    }

    public void setCustomerReviewAverage(Double customerReviewAverage) {
        this.customerReviewAverage = customerReviewAverage;
    }

    public Boolean getCustomerTopRated() {
        return customerTopRated;
    }

    public void setCustomerTopRated(Boolean customerTopRated) {
        this.customerTopRated = customerTopRated;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getFreeShippingEligible() {
        return freeShippingEligible;
    }

    public void setFreeShippingEligible(Boolean freeShippingEligible) {
        this.freeShippingEligible = freeShippingEligible;
    }

    public Boolean getInStoreAvailability() {
        return inStoreAvailability;
    }

    public void setInStoreAvailability(Boolean inStoreAvailability) {
        this.inStoreAvailability = inStoreAvailability;
    }

    public String getInStoreAvailabilityText() {
        return inStoreAvailabilityText;
    }

    public void setInStoreAvailabilityText(String inStoreAvailabilityText) {
        this.inStoreAvailabilityText = inStoreAvailabilityText;
    }

    public String getInStoreAvailabilityTextHtml() {
        return inStoreAvailabilityTextHtml;
    }

    public void setInStoreAvailabilityTextHtml(String inStoreAvailabilityTextHtml) {
        this.inStoreAvailabilityTextHtml = inStoreAvailabilityTextHtml;
    }

    public String getInStoreAvailabilityUpdateDate() {
        return inStoreAvailabilityUpdateDate;
    }

    public void setInStoreAvailabilityUpdateDate(String inStoreAvailabilityUpdateDate) {
        this.inStoreAvailabilityUpdateDate = inStoreAvailabilityUpdateDate;
    }

    public String getItemUpdateDate() {
        return itemUpdateDate;
    }

    public void setItemUpdateDate(String itemUpdateDate) {
        this.itemUpdateDate = itemUpdateDate;
    }

    public Boolean getOnlineAvailability() {
        return onlineAvailability;
    }

    public void setOnlineAvailability(Boolean onlineAvailability) {
        this.onlineAvailability = onlineAvailability;
    }

    public String getOnlineAvailabilityText() {
        return onlineAvailabilityText;
    }

    public void setOnlineAvailabilityText(String onlineAvailabilityText) {
        this.onlineAvailabilityText = onlineAvailabilityText;
    }

    public String getOnlineAvailabilityTextHtml() {
        return onlineAvailabilityTextHtml;
    }

    public void setOnlineAvailabilityTextHtml(String onlineAvailabilityTextHtml) {
        this.onlineAvailabilityTextHtml = onlineAvailabilityTextHtml;
    }

    public String getOnlineAvailabilityUpdateDate() {
        return onlineAvailabilityUpdateDate;
    }

    public void setOnlineAvailabilityUpdateDate(String onlineAvailabilityUpdateDate) {
        this.onlineAvailabilityUpdateDate = onlineAvailabilityUpdateDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    public List<Shipping> getShipping() {
        return shipping;
    }

    public void setShipping(List<Shipping> shipping) {
        this.shipping = shipping;
    }

    public List<ShippingLevelsOfService> getShippingLevelsOfService() {
        return shippingLevelsOfService;
    }

    public void setShippingLevelsOfService(List<ShippingLevelsOfService> shippingLevelsOfService) {
        this.shippingLevelsOfService = shippingLevelsOfService;
    }

    public Boolean getSpecialOrder() {
        return specialOrder;
    }

    public void setSpecialOrder(Boolean specialOrder) {
        this.specialOrder = specialOrder;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescriptionHtml() {
        return shortDescriptionHtml;
    }

    public void setShortDescriptionHtml(String shortDescriptionHtml) {
        this.shortDescriptionHtml = shortDescriptionHtml;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public Integer getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Integer subclassId) {
        this.subclassId = subclassId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getBestBuyItemId() {
        return bestBuyItemId;
    }

    public void setBestBuyItemId(String bestBuyItemId) {
        this.bestBuyItemId = bestBuyItemId;
    }

    public String getProtectionPlanTerm() {
        return protectionPlanTerm;
    }

    public void setProtectionPlanTerm(String protectionPlanTerm) {
        this.protectionPlanTerm = protectionPlanTerm;
    }

    public Object getProtectionPlanType() {
        return protectionPlanType;
    }

    public void setProtectionPlanType(Object protectionPlanType) {
        this.protectionPlanType = protectionPlanType;
    }

    public String getProtectionPlanLowPrice() {
        return protectionPlanLowPrice;
    }

    public void setProtectionPlanLowPrice(String protectionPlanLowPrice) {
        this.protectionPlanLowPrice = protectionPlanLowPrice;
    }

    public String getProtectionPlanHighPrice() {
        return protectionPlanHighPrice;
    }

    public void setProtectionPlanHighPrice(String protectionPlanHighPrice) {
        this.protectionPlanHighPrice = protectionPlanHighPrice;
    }

    public List<Object> getBuybackPlans() {
        return buybackPlans;
    }

    public void setBuybackPlans(List<Object> buybackPlans) {
        this.buybackPlans = buybackPlans;
    }

    public List<Object> getProtectionPlans() {
        return protectionPlans;
    }

    public void setProtectionPlans(List<Object> protectionPlans) {
        this.protectionPlans = protectionPlans;
    }

    public List<Object> getProtectionPlanDetails() {
        return protectionPlanDetails;
    }

    public void setProtectionPlanDetails(List<Object> protectionPlanDetails) {
        this.protectionPlanDetails = protectionPlanDetails;
    }

    public List<Object> getProductFamilies() {
        return productFamilies;
    }

    public void setProductFamilies(List<Object> productFamilies) {
        this.productFamilies = productFamilies;
    }

    public List<ProductVariation> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(List<ProductVariation> productVariations) {
        this.productVariations = productVariations;
    }

    public Object getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(Object aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Object getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(Object screenFormat) {
        this.screenFormat = screenFormat;
    }

    public Object getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(Object lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public Object getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(Object mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Object getPlot() {
        return plot;
    }

    public void setPlot(Object plot) {
        this.plot = plot;
    }

    public Object getPlotHtml() {
        return plotHtml;
    }

    public void setPlotHtml(Object plotHtml) {
        this.plotHtml = plotHtml;
    }

    public Object getStudio() {
        return studio;
    }

    public void setStudio(Object studio) {
        this.studio = studio;
    }

    public Object getTheatricalReleaseDate() {
        return theatricalReleaseDate;
    }

    public void setTheatricalReleaseDate(Object theatricalReleaseDate) {
        this.theatricalReleaseDate = theatricalReleaseDate;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLargeFrontImage() {
        return largeFrontImage;
    }

    public void setLargeFrontImage(String largeFrontImage) {
        this.largeFrontImage = largeFrontImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getAlternateViewsImage() {
        return alternateViewsImage;
    }

    public void setAlternateViewsImage(String alternateViewsImage) {
        this.alternateViewsImage = alternateViewsImage;
    }

    public Object getAngleImage() {
        return angleImage;
    }

    public void setAngleImage(Object angleImage) {
        this.angleImage = angleImage;
    }

    public Object getBackViewImage() {
        return backViewImage;
    }

    public void setBackViewImage(Object backViewImage) {
        this.backViewImage = backViewImage;
    }

    public Object getEnergyGuideImage() {
        return energyGuideImage;
    }

    public void setEnergyGuideImage(Object energyGuideImage) {
        this.energyGuideImage = energyGuideImage;
    }

    public Object getLeftViewImage() {
        return leftViewImage;
    }

    public void setLeftViewImage(Object leftViewImage) {
        this.leftViewImage = leftViewImage;
    }

    public Object getAccessoriesImage() {
        return accessoriesImage;
    }

    public void setAccessoriesImage(Object accessoriesImage) {
        this.accessoriesImage = accessoriesImage;
    }

    public Object getRemoteControlImage() {
        return remoteControlImage;
    }

    public void setRemoteControlImage(Object remoteControlImage) {
        this.remoteControlImage = remoteControlImage;
    }

    public Object getRightViewImage() {
        return rightViewImage;
    }

    public void setRightViewImage(Object rightViewImage) {
        this.rightViewImage = rightViewImage;
    }

    public Object getTopViewImage() {
        return topViewImage;
    }

    public void setTopViewImage(Object topViewImage) {
        this.topViewImage = topViewImage;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Object getArtistName() {
        return artistName;
    }

    public void setArtistName(Object artistName) {
        this.artistName = artistName;
    }

    public Object getArtistId() {
        return artistId;
    }

    public void setArtistId(Object artistId) {
        this.artistId = artistId;
    }

    public Object getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public void setOriginalReleaseDate(Object originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    public Object getParentalAdvisory() {
        return parentalAdvisory;
    }

    public void setParentalAdvisory(Object parentalAdvisory) {
        this.parentalAdvisory = parentalAdvisory;
    }

    public Object getMediaCount() {
        return mediaCount;
    }

    public void setMediaCount(Object mediaCount) {
        this.mediaCount = mediaCount;
    }

    public Object getMonoStereo() {
        return monoStereo;
    }

    public void setMonoStereo(Object monoStereo) {
        this.monoStereo = monoStereo;
    }

    public Object getStudioLive() {
        return studioLive;
    }

    public void setStudioLive(Object studioLive) {
        this.studioLive = studioLive;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getInStorePickup() {
        return inStorePickup;
    }

    public void setInStorePickup(Boolean inStorePickup) {
        this.inStorePickup = inStorePickup;
    }

    public Boolean getFriendsAndFamilyPickup() {
        return friendsAndFamilyPickup;
    }

    public void setFriendsAndFamilyPickup(Boolean friendsAndFamilyPickup) {
        this.friendsAndFamilyPickup = friendsAndFamilyPickup;
    }

    public Boolean getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(Boolean homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public Integer getQuantityLimit() {
        return quantityLimit;
    }

    public void setQuantityLimit(Integer quantityLimit) {
        this.quantityLimit = quantityLimit;
    }

    public String getFulfilledBy() {
        return fulfilledBy;
    }

    public void setFulfilledBy(String fulfilledBy) {
        this.fulfilledBy = fulfilledBy;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    public List<Object> getBundledIn() {
        return bundledIn;
    }

    public void setBundledIn(List<Object> bundledIn) {
        this.bundledIn = bundledIn;
    }

    public Object getAlbumLabel() {
        return albumLabel;
    }

    public void setAlbumLabel(Object albumLabel) {
        this.albumLabel = albumLabel;
    }

    public Object getGenre() {
        return genre;
    }

    public void setGenre(Object genre) {
        this.genre = genre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
        this.depth = depth;
    }

    public Integer getDollarSavings() {
        return dollarSavings;
    }

    public void setDollarSavings(Integer dollarSavings) {
        this.dollarSavings = dollarSavings;
    }

    public String getPercentSavings() {
        return percentSavings;
    }

    public void setPercentSavings(String percentSavings) {
        this.percentSavings = percentSavings;
    }

    public String getTradeInValue() {
        return tradeInValue;
    }

    public void setTradeInValue(String tradeInValue) {
        this.tradeInValue = tradeInValue;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public String getOrderable() {
        return orderable;
    }

    public void setOrderable(String orderable) {
        this.orderable = orderable;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public Double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(Double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public String getWarrantyLabor() {
        return warrantyLabor;
    }

    public void setWarrantyLabor(String warrantyLabor) {
        this.warrantyLabor = warrantyLabor;
    }

    public String getWarrantyParts() {
        return warrantyParts;
    }

    public void setWarrantyParts(String warrantyParts) {
        this.warrantyParts = warrantyParts;
    }

    public Object getSoftwareAge() {
        return softwareAge;
    }

    public void setSoftwareAge(Object softwareAge) {
        this.softwareAge = softwareAge;
    }

    public Object getSoftwareGrade() {
        return softwareGrade;
    }

    public void setSoftwareGrade(Object softwareGrade) {
        this.softwareGrade = softwareGrade;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Object getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Object numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Object getSoftwareNumberOfPlayers() {
        return softwareNumberOfPlayers;
    }

    public void setSoftwareNumberOfPlayers(Object softwareNumberOfPlayers) {
        this.softwareNumberOfPlayers = softwareNumberOfPlayers;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getLongDescriptionHtml() {
        return longDescriptionHtml;
    }

    public void setLongDescriptionHtml(String longDescriptionHtml) {
        this.longDescriptionHtml = longDescriptionHtml;
    }

    public List<Object> getCast() {
        return cast;
    }

    public void setCast(List<Object> cast) {
        this.cast = cast;
    }

    public List<Object> getCrew() {
        return crew;
    }

    public void setCrew(List<Object> crew) {
        this.crew = crew;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public List<IncludedItemList> getIncludedItemList() {
        return includedItemList;
    }

    public void setIncludedItemList(List<IncludedItemList> includedItemList) {
        this.includedItemList = includedItemList;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public Boolean getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    public Object getListingId() {
        return listingId;
    }

    public void setListingId(Object listingId) {
        this.listingId = listingId;
    }

    public Object getSellerId() {
        return sellerId;
    }

    public void setSellerId(Object sellerId) {
        this.sellerId = sellerId;
    }

    public Object getShippingRestrictions() {
        return shippingRestrictions;
    }

    public void setShippingRestrictions(Object shippingRestrictions) {
        this.shippingRestrictions = shippingRestrictions;
    }

    public List<Object> getDiscs() {
        return discs;
    }

    public void setDiscs(List<Object> discs) {
        this.discs = discs;
    }

    public Integer getCommerceSku() {
        return commerceSku;
    }

    public void setCommerceSku(Integer commerceSku) {
        this.commerceSku = commerceSku;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sku);
        dest.writeValue(score);
        dest.writeValue(productId);
        dest.writeValue(name);
        dest.writeValue(source);
        dest.writeValue(type);
        dest.writeValue(startDate);
        dest.writeValue(_new);
        dest.writeValue(active);
        dest.writeValue(lowPriceGuarantee);
        dest.writeValue(activeUpdateDate);
        dest.writeValue(regularPrice);
        dest.writeValue(salePrice);
        dest.writeValue(clearance);
        dest.writeValue(onSale);
        dest.writeValue(planPrice);
        dest.writeList(priceWithPlan);
        dest.writeList(contracts);
        dest.writeValue(priceRestriction);
        dest.writeValue(priceUpdateDate);
        dest.writeValue(digital);
        dest.writeValue(preowned);
        dest.writeList(carriers);
        dest.writeList(planFeatures);
        dest.writeList(devices);
        dest.writeList(carrierPlans);
        dest.writeValue(technologyCode);
        dest.writeValue(carrierModelNumber);
        dest.writeList(earlyTerminationFees);
        dest.writeValue(monthlyRecurringCharge);
        dest.writeValue(monthlyRecurringChargeGrandTotal);
        dest.writeValue(activationCharge);
        dest.writeValue(minutePrice);
        dest.writeValue(planCategory);
        dest.writeValue(planType);
        dest.writeValue(familyIndividualCode);
        dest.writeValue(validFrom);
        dest.writeValue(validUntil);
        dest.writeValue(carrierPlan);
        dest.writeValue(outletCenter);
        dest.writeValue(secondaryMarket);
        dest.writeList(frequentlyPurchasedWith);
        dest.writeList(accessories);
        dest.writeList(relatedProducts);
        dest.writeList(techSupportPlans);
        dest.writeList(crossSell);
        dest.writeValue(salesRankShortTerm);
        dest.writeValue(salesRankMediumTerm);
        dest.writeValue(salesRankLongTerm);
        dest.writeValue(bestSellingRank);
        dest.writeValue(url);
        dest.writeValue(spin360Url);
        dest.writeValue(mobileUrl);
        dest.writeValue(affiliateUrl);
        dest.writeValue(addToCartUrl);
        dest.writeValue(affiliateAddToCartUrl);
        dest.writeValue(linkShareAffiliateUrl);
        dest.writeValue(linkShareAffiliateAddToCartUrl);
        dest.writeValue(search);
        dest.writeValue(upc);
        dest.writeValue(productTemplate);
        dest.writeList(categoryPath);
        dest.writeList(alternateCategories);
        dest.writeList(lists);
        dest.writeValue(customerReviewCount);
        dest.writeValue(customerReviewAverage);
        dest.writeValue(customerTopRated);
        dest.writeValue(format);
        dest.writeValue(freeShipping);
        dest.writeValue(freeShippingEligible);
        dest.writeValue(inStoreAvailability);
        dest.writeValue(inStoreAvailabilityText);
        dest.writeValue(inStoreAvailabilityTextHtml);
        dest.writeValue(inStoreAvailabilityUpdateDate);
        dest.writeValue(itemUpdateDate);
        dest.writeValue(onlineAvailability);
        dest.writeValue(onlineAvailabilityText);
        dest.writeValue(onlineAvailabilityTextHtml);
        dest.writeValue(onlineAvailabilityUpdateDate);
        dest.writeValue(releaseDate);
        dest.writeValue(shippingCost);
        dest.writeList(shipping);
        dest.writeList(shippingLevelsOfService);
        dest.writeValue(specialOrder);
        dest.writeValue(shortDescription);
        dest.writeValue(shortDescriptionHtml);
        dest.writeValue(_class);
        dest.writeValue(classId);
        dest.writeValue(subclass);
        dest.writeValue(subclassId);
        dest.writeValue(department);
        dest.writeValue(departmentId);
        dest.writeValue(bestBuyItemId);
        dest.writeValue(protectionPlanTerm);
        dest.writeValue(protectionPlanType);
        dest.writeValue(protectionPlanLowPrice);
        dest.writeValue(protectionPlanHighPrice);
        dest.writeList(buybackPlans);
        dest.writeList(protectionPlans);
        dest.writeList(protectionPlanDetails);
        dest.writeList(productFamilies);
        dest.writeList(productVariations);
        dest.writeValue(aspectRatio);
        dest.writeValue(screenFormat);
        dest.writeValue(lengthInMinutes);
        dest.writeValue(mpaaRating);
        dest.writeValue(plot);
        dest.writeValue(plotHtml);
        dest.writeValue(studio);
        dest.writeValue(theatricalReleaseDate);
        dest.writeValue(description);
        dest.writeValue(manufacturer);
        dest.writeValue(modelNumber);
        dest.writeValue(image);
        dest.writeValue(largeFrontImage);
        dest.writeValue(mediumImage);
        dest.writeValue(thumbnailImage);
        dest.writeValue(largeImage);
        dest.writeValue(alternateViewsImage);
        dest.writeValue(angleImage);
        dest.writeValue(backViewImage);
        dest.writeValue(energyGuideImage);
        dest.writeValue(leftViewImage);
        dest.writeValue(accessoriesImage);
        dest.writeValue(remoteControlImage);
        dest.writeValue(rightViewImage);
        dest.writeValue(topViewImage);
        dest.writeValue(albumTitle);
        dest.writeValue(artistName);
        dest.writeValue(artistId);
        dest.writeValue(originalReleaseDate);
        dest.writeValue(parentalAdvisory);
        dest.writeValue(mediaCount);
        dest.writeValue(monoStereo);
        dest.writeValue(studioLive);
        dest.writeValue(condition);
        dest.writeValue(inStorePickup);
        dest.writeValue(friendsAndFamilyPickup);
        dest.writeValue(homeDelivery);
        dest.writeValue(quantityLimit);
        dest.writeValue(fulfilledBy);
        dest.writeList(members);
        dest.writeList(bundledIn);
        dest.writeValue(albumLabel);
        dest.writeValue(genre);
        dest.writeValue(color);
        dest.writeValue(depth);
        dest.writeValue(dollarSavings);
        dest.writeValue(percentSavings);
        dest.writeValue(tradeInValue);
        dest.writeValue(height);
        dest.writeValue(orderable);
        dest.writeValue(weight);
        dest.writeValue(shippingWeight);
        dest.writeValue(width);
        dest.writeValue(warrantyLabor);
        dest.writeValue(warrantyParts);
        dest.writeValue(softwareAge);
        dest.writeValue(softwareGrade);
        dest.writeValue(platform);
        dest.writeValue(numberOfPlayers);
        dest.writeValue(softwareNumberOfPlayers);
        dest.writeValue(esrbRating);
        dest.writeValue(longDescription);
        dest.writeValue(longDescriptionHtml);
        dest.writeList(cast);
        dest.writeList(crew);
        dest.writeList(details);
        dest.writeList(includedItemList);
        dest.writeList(features);
        dest.writeList(offers);
        dest.writeValue(marketplace);
        dest.writeValue(listingId);
        dest.writeValue(sellerId);
        dest.writeValue(shippingRestrictions);
        dest.writeList(discs);
        dest.writeValue(commerceSku);
    }

    public int describeContents() {
        return  0;
    }

}
