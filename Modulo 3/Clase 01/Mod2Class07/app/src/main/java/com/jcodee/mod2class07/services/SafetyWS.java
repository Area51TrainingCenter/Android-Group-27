package com.jcodee.mod2class07.services;

import com.jcodee.mod2class07.request.SafetyRequest;
import com.jcodee.mod2class07.response.AppResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by johannfjs on 29/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface SafetyWS {
    @Headers({"Accept: application/json",
            "Content-Type: application/json"})
    @POST("api/app")
    Call<AppResponse> app(@Body SafetyRequest safetyRequest);

    @GET("{url}/api/app")
    Call<ZzyResponse> verificar(@Path("url") String url);
}
