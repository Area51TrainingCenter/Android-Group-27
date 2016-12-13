package com.jcodee.mod2class07.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johannfjs on 29/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HelperWS {
    public static Retrofit getConfiguration() {
        return new Retrofit.Builder()
                .baseUrl("http://services.dev.safetyauth.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
