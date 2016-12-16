package com.jcodee.mod3class3;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodee.mod3class3.adapters.AlbumAdapter;
import com.jcodee.mod3class3.entities.Photo;
import com.jcodee.mod3class3.rest.HelperWS;
import com.jcodee.mod3class3.rest.PlaceHolderWS;
import com.jcodee.mod3class3.rest.response.PhotoResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends BaseActivity {

    @BindView(R.id.rvAlbum)
    RecyclerView rvAlbum;
    private ArrayList<Photo> listaFotos = new ArrayList<>();
    private AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        //Validar a cual se debe de consultar
        obtenerFotos();
    }

    private void obtenerFotos() {
        PlaceHolderWS placeHolderWS =
                HelperWS.getConfiguration()
                        .create(PlaceHolderWS.class);
        Call<ArrayList<PhotoResponse>> respuesta =
                placeHolderWS.obtenerFotos();
        respuesta.enqueue(new Callback<ArrayList<PhotoResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotoResponse>> call, Response<ArrayList<PhotoResponse>> response) {
                ArrayList<PhotoResponse> result = response.body();
                if (result != null) {
                    for (PhotoResponse item : result) {
                        Photo foto = new Photo();
                        foto.setId(item.getId());
                        foto.setAlbumId(item.getAlbumId());
                        foto.setTitle(item.getTitle());
                        foto.setUrl(item.getUrl());
                        listaFotos.add(foto);
                    }
                    //Se debe de registrar a bd
                    adapter = new AlbumAdapter(AlbumActivity.this, listaFotos);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(AlbumActivity.this);
                    rvAlbum.setLayoutManager(layoutManager);
                    rvAlbum.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PhotoResponse>> call, Throwable t) {

            }
        });
    }
}
