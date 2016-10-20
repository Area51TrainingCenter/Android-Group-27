package com.jcodee.mod1class4.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod1class4.R;
import com.jcodee.mod1class4.modelos.Usuario;
import com.jcodee.mod1class4.views.TextViewCustom;

import java.util.ArrayList;

/**
 * Created by johannfjs on 13/10/16.
 */

public class UsuarioAdapter extends BaseAdapter {
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    //Cantidad de elementos que hay en la lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Obtenemos un elemento de la lista según la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Obtenemos el id de un elemento de la lista según la posición
    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    //Incluir el diseño en la vista de cada item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Validamos si el diseño se encuentra cargado
        //if (convertView == null) {
        //Si no se encuentra cargado, vamos a cargarlo
        //parent.getContext() obtiene el contexto o la pantalla donde
        //se están realizando los cambios
        //inflate = encargado de cargar el diseño
        if (position % 2 == 0) {
            convertView =
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.item_usuario, parent, false);
        } else {
            convertView =
                    LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.item_usuario_2, parent, false);
        }
        //}

        //Obtenemos los datos del usuario
        Usuario usuario = (Usuario) getItem(position);

        //Declaramos los componentes
        TextView tvNombre, tvUsuario;
        TextViewCustom tvGenero, tvEstado;
        SimpleDraweeView sdvImagen;
        LinearLayout contenido;

        //Vinculamos las variables a nuestros componentes
        tvNombre = (TextView) convertView.findViewById(R.id.tvNombreCompleto);
        tvUsuario = (TextView) convertView.findViewById(R.id.tvUsuario);
        tvGenero = (TextViewCustom) convertView.findViewById(R.id.tvGenero);
        tvEstado = (TextViewCustom) convertView.findViewById(R.id.tvEstado);
        sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
        contenido = (LinearLayout) convertView.findViewById(R.id.contenido);

        //Setear los valores de los componentes
        tvNombre.setText(usuario.getNombre() + " " + usuario.getApellido());
        tvUsuario.setText(usuario.getUsuario());
        tvEstado.setText(usuario.getEstado());
        tvGenero.setText(usuario.getGenero());
        sdvImagen.setImageURI(Uri.parse("http://sassystickers.com/images/android-batman.jpg"));
        if (position % 2 == 0) {
            contenido.setBackgroundColor(
                    parent.getContext()
                            .getResources()
                            .getColor(R.color.colorAccent)
            );
        } else {
            contenido.setBackgroundColor(
                    parent.getContext()
                            .getResources()
                            .getColor(android.R.color.darker_gray)
            );
        }

        //Retornamos el diseño
        return convertView;
    }
}
