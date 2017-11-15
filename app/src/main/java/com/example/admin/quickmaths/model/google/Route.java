
package com.example.admin.quickmaths.model.google;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route implements Serializable {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = null;
    @SerializedName("overview_polyline")
    @Expose
    private OverviewPolyline overviewPolyline;

    public OverviewPolyline getOverviewPolyline() { return overviewPolyline; }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {this.overviewPolyline = overviewPolyline; }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

}
