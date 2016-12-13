package com.jcodee.mod2class07.request;

/**
 * Created by johannfjs on 6/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AppRequest {
    private int ApiProductId;
    private String Name;
    private String Description;
    private String WebSite;
    private int AppType;
    private int AccessTokenExpireTime;
    private int RefreshTokenTime;

    public int getApiProductId() {
        return ApiProductId;
    }

    public void setApiProductId(int apiProductId) {
        ApiProductId = apiProductId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public int getAppType() {
        return AppType;
    }

    public void setAppType(int appType) {
        AppType = appType;
    }

    public int getAccessTokenExpireTime() {
        return AccessTokenExpireTime;
    }

    public void setAccessTokenExpireTime(int accessTokenExpireTime) {
        AccessTokenExpireTime = accessTokenExpireTime;
    }

    public int getRefreshTokenTime() {
        return RefreshTokenTime;
    }

    public void setRefreshTokenTime(int refreshTokenTime) {
        RefreshTokenTime = refreshTokenTime;
    }
}
