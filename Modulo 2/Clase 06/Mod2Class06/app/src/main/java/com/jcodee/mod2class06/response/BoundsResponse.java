package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class BoundsResponse {
    @SerializedName("northeast")
    private LatLongResponse northeast;
    @SerializedName("southwest")
    private LatLongResponse southwest;

    public LatLongResponse getNortheast() {
        return northeast;
    }

    public void setNortheast(LatLongResponse northeast) {
        this.northeast = northeast;
    }

    public LatLongResponse getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LatLongResponse southwest) {
        this.southwest = southwest;
    }
}
