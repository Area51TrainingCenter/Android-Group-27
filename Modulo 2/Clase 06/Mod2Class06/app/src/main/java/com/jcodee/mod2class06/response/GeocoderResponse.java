package com.jcodee.mod2class06.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */


// [ -> array
// { -> objeto
public class GeocoderResponse extends BaseResponse {
    @SerializedName("results")
    private ArrayList<ResultResponse> results;

    public ArrayList<ResultResponse> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultResponse> results) {
        this.results = results;
    }
}
