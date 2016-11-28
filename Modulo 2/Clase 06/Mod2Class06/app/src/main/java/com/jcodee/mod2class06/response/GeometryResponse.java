package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GeometryResponse {
    @SerializedName("bounds")
    private BoundsResponse bounds;

    public BoundsResponse getBounds() {
        return bounds;
    }

    public void setBounds(BoundsResponse bounds) {
        this.bounds = bounds;
    }
}
