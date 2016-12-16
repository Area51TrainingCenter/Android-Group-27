package com.jcodee.mod3class3.entities;

import io.realm.RealmObject;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Post extends RealmObject {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
