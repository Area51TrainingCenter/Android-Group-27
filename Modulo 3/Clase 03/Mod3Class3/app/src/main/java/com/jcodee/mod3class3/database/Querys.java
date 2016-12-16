package com.jcodee.mod3class3.database;

import com.jcodee.mod3class3.entities.Comment;
import com.jcodee.mod3class3.entities.Photo;
import com.jcodee.mod3class3.entities.Post;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Querys {
    public boolean insertarPost(ArrayList<Post> list) {
        boolean result = false;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(list);

            realm.commitTransaction();
            result = true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public ArrayList<Post> obtenerPost() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Post> resulta = realm.where(Post.class).findAll();

        ArrayList<Post> posts = new ArrayList<>();
        for (Post item : resulta) {
            posts.add(item);
        }
        return posts;
    }

    public boolean insertarFotos(ArrayList<Photo> list) {
        boolean result = false;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(list);

            realm.commitTransaction();
            result = true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public ArrayList<Photo> obtenerFotos() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Photo> resulta = realm.where(Photo.class).findAll();

        ArrayList<Photo> posts = new ArrayList<>();
        for (Photo item : resulta) {
            posts.add(item);
        }
        return posts;
    }

    public boolean insertarComment(ArrayList<Comment> list) {
        boolean result = false;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(list);

            realm.commitTransaction();
            result = true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public ArrayList<Comment> obtenerComentarios() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Comment> resulta = realm.where(Comment.class).findAll();

        ArrayList<Comment> posts = new ArrayList<>();
        for (Comment item : resulta) {
            posts.add(item);
        }
        return posts;
    }
}
