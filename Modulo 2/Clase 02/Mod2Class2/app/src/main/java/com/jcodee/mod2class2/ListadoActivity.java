package com.jcodee.mod2class2;

import android.os.Bundle;
import android.widget.TextView;

import com.jcodee.mod2class2.entidades.Persona;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends BaseActivity {

    @BindView(R.id.tvResultado)
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ArrayList<Persona> lista = sentencias.obtenerPersonas();
        StringBuilder dato = new StringBuilder();
        for (Persona item : lista) {
            dato.append(item.getId());
            dato.append("\n");
            dato.append(item.getNombreCompleto());
            dato.append("\n");
            dato.append(item.getEdad());
            dato.append("\n-----\n");
        }
        tvResultado.setText(dato.toString());
    }
}
