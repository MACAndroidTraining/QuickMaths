
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncludedItemList implements Parcelable
{

    @SerializedName("includedItem")
    @Expose
    private String includedItem;
    public final static Parcelable.Creator<IncludedItemList> CREATOR = new Creator<IncludedItemList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IncludedItemList createFromParcel(Parcel in) {
            return new IncludedItemList(in);
        }

        public IncludedItemList[] newArray(int size) {
            return (new IncludedItemList[size]);
        }

    }
    ;

    protected IncludedItemList(Parcel in) {
        this.includedItem = ((String) in.readValue((String.class.getClassLoader())));
    }

    public IncludedItemList() {
    }

    public String getIncludedItem() {
        return includedItem;
    }

    public void setIncludedItem(String includedItem) {
        this.includedItem = includedItem;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(includedItem);
    }

    public int describeContents() {
        return  0;
    }

}
