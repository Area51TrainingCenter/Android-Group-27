package com.jcodee.mod1class3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Author: johannfjs
 * Date: 6/10/16
 * Time: 21:20
 */

public class DosActivity extends AppCompatActivity {
    private TextView tvDatos;
    private Button btnAtras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        tvDatos = (TextView) findViewById(R.id.tvDatos);
        btnAtras = (Button) findViewById(R.id.btnAtras);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Verificamos que el dato exista
        if (getIntent().hasExtra("nombre")) {
            //Obtenemos el valor del dato
            String nombre = getIntent().getStringExtra("nombre");

            //Seteamos el valor del componente con el dato capturado
            tvDatos.setText(nombre);
        }

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
