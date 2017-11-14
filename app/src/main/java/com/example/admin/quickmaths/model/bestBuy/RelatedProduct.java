
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedProduct implements Parcelable
{

    @SerializedName("sku")
    @Expose
    private Integer sku;
    public final static Parcelable.Creator<RelatedProduct> CREATOR = new Creator<RelatedProduct>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RelatedProduct createFromParcel(Parcel in) {
            return new RelatedProduct(in);
        }

        public RelatedProduct[] newArray(int size) {
            return (new RelatedProduct[size]);
        }

    }
    ;

    protected RelatedProduct(Parcel in) {
        this.sku = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public RelatedProduct() {
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sku);
    }

    public int describeContents() {
        return  0;
    }

}
