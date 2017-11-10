
package com.example.admin.quickmaths.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DirectionsResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("geocoded_waypoints")
    @Expose
    private List<GeocodedWaypoint> geocodedWaypoints = null;
    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

}
