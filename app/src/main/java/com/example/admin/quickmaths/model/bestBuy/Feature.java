
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature implements Parcelable
{

    @SerializedName("feature")
    @Expose
    private String feature;
    public final static Parcelable.Creator<Feature> CREATOR = new Creator<Feature>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        public Feature[] newArray(int size) {
            return (new Feature[size]);
        }

    }
    ;

    protected Feature(Parcel in) {
        this.feature = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Feature() {
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(feature);
    }

    public int describeContents() {
        return  0;
    }

}
