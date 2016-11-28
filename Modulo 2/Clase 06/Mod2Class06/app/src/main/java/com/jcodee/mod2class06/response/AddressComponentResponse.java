package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AddressComponentResponse {
    @SerializedName("long_name")
    private String longName;
    @SerializedName("short_name")
    private String shortName;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
