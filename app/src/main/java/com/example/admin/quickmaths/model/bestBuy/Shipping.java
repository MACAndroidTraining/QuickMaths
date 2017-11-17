
package com.example.admin.quickmaths.model.bestBuy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipping implements Parcelable
{

    @SerializedName("ground")
    @Expose
    private Integer ground;
    @SerializedName("secondDay")
    @Expose
    private Double secondDay;
    @SerializedName("nextDay")
    @Expose
    private Double nextDay;
    @SerializedName("vendorDelivery")
    @Expose
    private String vendorDelivery;
    public final static Parcelable.Creator<Shipping> CREATOR = new Creator<Shipping>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shipping createFromParcel(Parcel in) {
            return new Shipping(in);
        }

        public Shipping[] newArray(int size) {
            return (new Shipping[size]);
        }

    }
    ;

    protected Shipping(Parcel in) {
        this.ground = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.secondDay = ((Double) in.readValue((Double.class.getClassLoader())));
        this.nextDay = ((Double) in.readValue((Double.class.getClassLoader())));
        this.vendorDelivery = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Shipping() {
    }

    public Integer getGround() {
        return ground;
    }

    public void setGround(Integer ground) {
        this.ground = ground;
    }

    public void setGround(String ground) {this.ground = 0;}

    public Double getSecondDay() {
        return secondDay;
    }

    public void setSecondDay(Double secondDay) {
        this.secondDay = secondDay;
    }

    public void setSecondDay(String secondDay) {
        this.secondDay = 0.0;
    }

    public Double getNextDay() {
        return nextDay;
    }

    public void setNextDay(Double nextDay) {
        this.nextDay = nextDay;
    }

    public void setNextDay(String nextDay) {
        this.nextDay = 0.0;
    }

    public String getVendorDelivery() {
        return vendorDelivery;
    }

    public void setVendorDelivery(String vendorDelivery) {
        this.vendorDelivery = vendorDelivery;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ground);
        dest.writeValue(secondDay);
        dest.writeValue(nextDay);
        dest.writeValue(vendorDelivery);
    }

    public int describeContents() {
        return  0;
    }

}
