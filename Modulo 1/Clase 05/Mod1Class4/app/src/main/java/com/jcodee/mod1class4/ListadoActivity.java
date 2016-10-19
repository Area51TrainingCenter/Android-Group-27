package com.jcodee.mod1class4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jcodee.mod1class4.adapters.UsuarioAdapter;
import com.jcodee.mod1class4.utils.Constante;

/**
 * Created by johannfjs on 11/10/16.
 */

public class ListadoActivity extends AppCompatActivity {
    private UsuarioAdapter adapter;

    private ListView lvLista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //Cargamos la variable con nuestro componente
        lvLista = (ListView) findViewById(R.id.lvLista);

        //Inicializamos nuestro adapter
        adapter=new UsuarioAdapter(Constante.listaUsuarios);
        //Cambiar la estructura de diseño de nuestro listado
        lvLista.setAdapter(adapter);
    }
}
