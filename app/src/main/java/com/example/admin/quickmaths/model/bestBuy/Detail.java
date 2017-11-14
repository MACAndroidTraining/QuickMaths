
package com.example.admin.quickmaths.model.bestBuy;

import java.util.List;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("values")
    @Expose
    @Valid
    private List<String> values = null;
    public final static Parcelable.Creator<Detail> CREATOR = new Creator<Detail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        public Detail[] newArray(int size) {
            return (new Detail[size]);
        }

    }
    ;

    protected Detail(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.values, (java.lang.String.class.getClassLoader()));
    }

    public Detail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
        dest.writeList(values);
    }

    public int describeContents() {
        return  0;
    }

}
