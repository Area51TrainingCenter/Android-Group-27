package com.jcodee.mod2class06.servicios;

import com.jcodee.mod2class06.response.GeocoderResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface GeocoderWS {
    @GET("geocode/json?latlng=-12.1021498,-77.0276599&sensor=true")
    Call<GeocoderResponse> geocoder();
}
