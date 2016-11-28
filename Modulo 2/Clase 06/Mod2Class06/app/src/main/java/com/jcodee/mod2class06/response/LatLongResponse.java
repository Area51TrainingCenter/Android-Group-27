package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class LatLongResponse {
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lng")
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
