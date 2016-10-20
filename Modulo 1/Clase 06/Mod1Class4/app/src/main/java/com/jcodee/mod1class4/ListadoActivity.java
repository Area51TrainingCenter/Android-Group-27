package com.jcodee.mod1class4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jcodee.mod1class4.adapters.UsuarioAdapter;
import com.jcodee.mod1class4.utils.Constante;

/**
 * Created by johannfjs on 11/10/16.
 */

public class ListadoActivity extends AppCompatActivity {
    private UsuarioAdapter adapter;

    private ListView lvLista;
    private TextView tvNombreUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //Cargamos la variable con nuestro componente
        lvLista = (ListView) findViewById(R.id.lvLista);
        tvNombreUsuario = (TextView) findViewById(R.id.tvNombreUsuario);

        //Inicializamos nuestro adapter
        adapter = new UsuarioAdapter(Constante.listaUsuarios);
        //Cambiar la estructura de diseño de nuestro listado
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("nombreCompleto")) {
                String nombreCompleto =
                        getIntent().getExtras()
                                .getString("nombreCompleto");
                tvNombreUsuario.setText(nombreCompleto);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Con el metodo, obtenemos la posición en la que nos encontramos
                //del listado, eso lo mandamos a la siguiente página y obtenemos los
                //datos desde ahí

                Intent intent =
                        new Intent(ListadoActivity.this,
                                DetalleActivity.class);
                intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });
    }
}
