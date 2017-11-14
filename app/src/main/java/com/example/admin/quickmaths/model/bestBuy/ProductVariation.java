
package com.example.admin.quickmaths.model.bestBuy;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductVariation implements Parcelable
{

    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("variations")
    @Expose
    @Valid
    private List<Variation> variations = null;
    public final static Parcelable.Creator<ProductVariation> CREATOR = new Creator<ProductVariation>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductVariation createFromParcel(Parcel in) {
            return new ProductVariation(in);
        }

        public ProductVariation[] newArray(int size) {
            return (new ProductVariation[size]);
        }

    }
    ;

    protected ProductVariation(Parcel in) {
        this.sku = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.variations, (com.example.admin.quickmaths.model.bestBuy.Variation.class.getClassLoader()));
    }

    public ProductVariation() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sku);
        dest.writeList(variations);
    }

    public int describeContents() {
        return  0;
    }

}
