package com.jcodee.mod1class8.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod1class8.R;
import com.jcodee.mod1class8.models.Galeria;

import java.util.ArrayList;

/**
 * Created by johannfjs on 25/10/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaAdapter extends ArrayAdapter<Galeria> {
    private ArrayList<Galeria> lista;
    private Context context;

    public GaleriaAdapter(Context context, ArrayList<Galeria> objects) {
        super(context, 0, objects);
        this.lista = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(
                R.layout.item_grid,
                parent,
                false
        );

        SimpleDraweeView sdvImagen = (SimpleDraweeView)
                convertView.findViewById(R.id.sdvImagen);

        TextView tvTexto = (TextView) convertView.findViewById(R.id.tvTexto);

        Galeria item = lista.get(position);
        sdvImagen.setImageURI(Uri.parse(item.getRuta()));
        tvTexto.setText("Imagen " + item.getId());

        return convertView;
    }
}
