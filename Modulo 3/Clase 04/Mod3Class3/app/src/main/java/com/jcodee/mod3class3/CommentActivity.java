package com.jcodee.mod3class3;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodee.mod3class3.adapters.CommentAdapter;
import com.jcodee.mod3class3.entities.Comment;
import com.jcodee.mod3class3.rest.HelperWS;
import com.jcodee.mod3class3.rest.PlaceHolderWS;
import com.jcodee.mod3class3.rest.response.CommentResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends BaseActivity {

    @BindView(R.id.rvComments)
    RecyclerView rvComments;
    private ArrayList<Comment> lista;
    private CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        if (getIntent().hasExtra("id")) {
            int id = getIntent().getIntExtra("id", -1);
            lista = new ArrayList<>();
            obtenerComentarios(id);
        }
    }

    private void obtenerComentarios(int id) {
        PlaceHolderWS placeHolderWS =
                HelperWS.getConfiguration().create(PlaceHolderWS.class);
        Call<ArrayList<CommentResponse>> commentResponses =
                placeHolderWS.obtenerComentarios(String.valueOf(id));
        commentResponses.enqueue(new Callback<ArrayList<CommentResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentResponse>> call, Response<ArrayList<CommentResponse>> response) {
                ArrayList<CommentResponse> respuesta = response.body();
                if (response != null) {
                    for (CommentResponse item : respuesta) {
                        Comment comment = new Comment();
                        comment.setId(item.getId());
                        comment.setBody(item.getBody());
                        comment.setEmail(item.getEmail());
                        comment.setName(item.getName());
                        comment.setPostId(item.getPostId());
                        lista.add(comment);
                    }
                    adapter = new CommentAdapter(CommentActivity.this, lista);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(CommentActivity.this);
                    rvComments.setLayoutManager(layoutManager);
                    rvComments.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CommentResponse>> call, Throwable t) {

            }
        });
    }
}
