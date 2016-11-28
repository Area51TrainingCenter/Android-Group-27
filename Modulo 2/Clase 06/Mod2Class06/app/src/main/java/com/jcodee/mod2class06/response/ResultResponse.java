package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ResultResponse {
    @SerializedName("address_components")
    private ArrayList<AddressComponentResponse> addressComponents;
    @SerializedName("formatted_address")
    private String formattedAddress;
    @SerializedName("geometry")
    private GeometryResponse geometry;

    public GeometryResponse getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryResponse geometry) {
        this.geometry = geometry;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public ArrayList<AddressComponentResponse> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(ArrayList<AddressComponentResponse> addressComponents) {
        this.addressComponents = addressComponents;
    }
}
