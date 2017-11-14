
package com.example.admin.quickmaths.model.bestBuy;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestBuy implements Parcelable
{

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("queryTime")
    @Expose
    private String queryTime;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("partial")
    @Expose
    private Boolean partial;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("products")
    @Expose
    @Valid
    private List<Product> products = null;
    public final static Parcelable.Creator<BestBuy> CREATOR = new Creator<BestBuy>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BestBuy createFromParcel(Parcel in) {
            return new BestBuy(in);
        }

        public BestBuy[] newArray(int size) {
            return (new BestBuy[size]);
        }

    }
    ;

    protected BestBuy(Parcel in) {
        this.from = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.to = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.queryTime = ((String) in.readValue((String.class.getClassLoader())));
        this.totalTime = ((String) in.readValue((String.class.getClassLoader())));
        this.partial = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.canonicalUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.products, (com.example.admin.quickmaths.model.bestBuy.Product.class.getClassLoader()));
    }

    public BestBuy() {
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(currentPage);
        dest.writeValue(total);
        dest.writeValue(totalPages);
        dest.writeValue(queryTime);
        dest.writeValue(totalTime);
        dest.writeValue(partial);
        dest.writeValue(canonicalUrl);
        dest.writeList(products);
    }

    public int describeContents() {
        return  0;
    }

}

// valid is also in Detail, product, ProductVariation