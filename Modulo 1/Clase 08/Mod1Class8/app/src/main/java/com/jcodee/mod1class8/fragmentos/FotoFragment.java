package com.jcodee.mod1class8.fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod1class8.MainActivity;
import com.jcodee.mod1class8.R;
import com.jcodee.mod1class8.models.Galeria;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private SimpleDraweeView sdvImagen;
    private TextView tvTexto;


    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_foto, container, false);

        sdvImagen = (SimpleDraweeView) root.findViewById(R.id.sdvImagen);
        tvTexto = (TextView) root.findViewById(R.id.tvTexto);

        Bundle bundle = getArguments();
        if (bundle.containsKey("posicion")) {
            int posicion = bundle.getInt("posicion");
            Galeria galeria = MainActivity.lista.get(posicion);
            sdvImagen.setImageURI(Uri.parse(galeria.getRuta()));
            tvTexto.setText("Imagen " + galeria.getId());
        }

        return root;
    }

}
