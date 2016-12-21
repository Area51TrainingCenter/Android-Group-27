package com.jcodee.mod3class3.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod3class3.R;
import com.jcodee.mod3class3.entities.Photo;
import com.jcodee.mod3class3.views.TextViewUno;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {
    private Context context;
    private ArrayList<Photo> lista;
    private int con = 0;

    public AlbumAdapter(Context context, ArrayList<Photo> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            con = 1;
        } else {
            con = 2;
        }
        return con;
    }

    @Override
    public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View root = LayoutInflater.from(context).inflate(
                    R.layout.item_album_left, parent, false
            );
            return new AlbumHolder(root);
        } else {
            View root = LayoutInflater.from(context).inflate(
                    R.layout.item_album_right, parent, false
            );
            return new AlbumHolder(root);
        }
    }

    @Override
    public void onBindViewHolder(AlbumHolder holder, int position) {
        Photo photo = lista.get(position);

        holder.tvTitle.setText(photo.getTitle());
        holder.sdvImagen.setImageURI(Uri.parse(photo.getUrl()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class AlbumHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvTitle)
        TextViewUno tvTitle;

        public AlbumHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
