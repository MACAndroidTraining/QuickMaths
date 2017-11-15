
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryPath implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<CategoryPath> CREATOR = new Creator<CategoryPath>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CategoryPath createFromParcel(Parcel in) {
            return new CategoryPath(in);
        }

        public CategoryPath[] newArray(int size) {
            return (new CategoryPath[size]);
        }

    }
    ;

    protected CategoryPath(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CategoryPath() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
