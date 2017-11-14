
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingLevelsOfService implements Parcelable
{

    @SerializedName("serviceLevelId")
    @Expose
    private Integer serviceLevelId;
    @SerializedName("serviceLevelName")
    @Expose
    private String serviceLevelName;
    @SerializedName("unitShippingPrice")
    @Expose
    private Double unitShippingPrice;
    public final static Parcelable.Creator<ShippingLevelsOfService> CREATOR = new Creator<ShippingLevelsOfService>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ShippingLevelsOfService createFromParcel(Parcel in) {
            return new ShippingLevelsOfService(in);
        }

        public ShippingLevelsOfService[] newArray(int size) {
            return (new ShippingLevelsOfService[size]);
        }

    }
    ;

    protected ShippingLevelsOfService(Parcel in) {
        this.serviceLevelId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.serviceLevelName = ((String) in.readValue((String.class.getClassLoader())));
        this.unitShippingPrice = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public ShippingLevelsOfService() {
    }

    public Integer getServiceLevelId() {
        return serviceLevelId;
    }

    public void setServiceLevelId(Integer serviceLevelId) {
        this.serviceLevelId = serviceLevelId;
    }

    public String getServiceLevelName() {
        return serviceLevelName;
    }

    public void setServiceLevelName(String serviceLevelName) {
        this.serviceLevelName = serviceLevelName;
    }

    public Double getUnitShippingPrice() {
        return unitShippingPrice;
    }

    public void setUnitShippingPrice(Double unitShippingPrice) {
        this.unitShippingPrice = unitShippingPrice;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(serviceLevelId);
        dest.writeValue(serviceLevelName);
        dest.writeValue(unitShippingPrice);
    }

    public int describeContents() {
        return  0;
    }

}
