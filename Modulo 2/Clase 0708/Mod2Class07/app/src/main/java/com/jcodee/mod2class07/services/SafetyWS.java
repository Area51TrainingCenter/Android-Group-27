package com.jcodee.mod2class07.services;

import com.jcodee.mod2class07.response.AppResponse;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by johannfjs on 29/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface SafetyWS {
    @POST("app")
    Call<AppResponse> app();
}
