package com.jcodee.mod2class07.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 29/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AppResponse {
    @SerializedName("identifier")
    private String identifier;
    @SerializedName("requestDate")
    private String requestDate;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("errorMessage")
    private String errorMessage;
    @SerializedName("responseDate")
    private String responseDate;
    @SerializedName("version")
    private String version;

    //POSTMAN

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
