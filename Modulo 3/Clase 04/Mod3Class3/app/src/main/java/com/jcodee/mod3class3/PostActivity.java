package com.jcodee.mod3class3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jcodee.mod3class3.adapters.PostAdapter;
import com.jcodee.mod3class3.entities.Post;
import com.jcodee.mod3class3.events.ClickListener;
import com.jcodee.mod3class3.events.RecyclerTouchListener;
import com.jcodee.mod3class3.rest.HelperWS;
import com.jcodee.mod3class3.rest.PlaceHolderWS;
import com.jcodee.mod3class3.rest.response.PostResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends BaseActivity {

    @BindView(R.id.rvListaPost)
    RecyclerView rvListaPost;

    private PostAdapter adapter;
    private ArrayList<Post> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        lista = new ArrayList<>();
        obtenerPost();
    }

    private void obtenerPost() {
        PlaceHolderWS placeHolderWS = HelperWS.getConfiguration()
                .create(PlaceHolderWS.class);
        Call<ArrayList<PostResponse>> postCall =
                placeHolderWS.obtenerPost();
        postCall.enqueue(new Callback<ArrayList<PostResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<PostResponse>> call, Response<ArrayList<PostResponse>> response) {
                ArrayList<PostResponse> respuesta = response.body();
                if (respuesta != null) {
                    for (PostResponse item : respuesta) {
                        Post post = new Post();
                        post.setId(item.getId());
                        post.setTitle(item.getTitle());
                        post.setBody(item.getBody());
                        post.setUserId(item.getUserId());
                        lista.add(post);
                    }
                    adapter = new PostAdapter(PostActivity.this, lista);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(PostActivity.this);
                    rvListaPost.setLayoutManager(layoutManager);
                    rvListaPost.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PostResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        rvListaPost.addOnItemTouchListener(new RecyclerTouchListener(
                PostActivity.this, rvListaPost, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(
                        new Intent(PostActivity.this, CommentActivity.class)
                                .putExtra("id", lista.get(position).getId())
                );
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }
        ));
    }
}
