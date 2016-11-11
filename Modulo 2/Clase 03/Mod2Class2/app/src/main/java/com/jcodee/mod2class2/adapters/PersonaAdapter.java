package com.jcodee.mod2class2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.mod2class2.R;
import com.jcodee.mod2class2.entidades.Persona;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 10/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PersonaAdapter extends BaseAdapter {
    private ArrayList<Persona> lista;
    private Context context;

    public PersonaAdapter(ArrayList<Persona> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(context)
                    .inflate(
                            R.layout.item,
                            parent,
                            false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Persona persona = (Persona) getItem(position);

        viewHolder.tvEdad.setText(String.valueOf(persona.getEdad()));
        viewHolder.tvNombreCompleto.setText(persona.getNombreCompleto());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvNombreCompleto)
        TextView tvNombreCompleto;
        @BindView(R.id.tvEdad)
        TextView tvEdad;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
