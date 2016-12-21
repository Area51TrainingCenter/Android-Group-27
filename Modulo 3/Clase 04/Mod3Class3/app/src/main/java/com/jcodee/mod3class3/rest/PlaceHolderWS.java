package com.jcodee.mod3class3.rest;

import com.jcodee.mod3class3.rest.response.CommentResponse;
import com.jcodee.mod3class3.rest.response.PhotoResponse;
import com.jcodee.mod3class3.rest.response.PostResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface PlaceHolderWS {
    @GET("photos")
    Call<ArrayList<PhotoResponse>> obtenerFotos();

    @GET("posts")
    Call<ArrayList<PostResponse>> obtenerPost();

    @GET("posts/{id}/comments")
    Call<ArrayList<CommentResponse>> obtenerComentarios(@Path("id") String id);
}
