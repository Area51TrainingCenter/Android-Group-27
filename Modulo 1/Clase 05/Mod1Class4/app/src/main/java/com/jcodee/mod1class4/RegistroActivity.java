package com.jcodee.mod1class4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.mod1class4.modelos.Usuario;
import com.jcodee.mod1class4.utils.Constante;

/**
 * Created by johannfjs on 11/10/16.
 */

public class RegistroActivity extends AppCompatActivity {
    private EditText etNombre, etApellido, etUsuario,
            etContrasena, etRepContrasena;
    private RadioButton rbMasculino, rbFemenino;
    private Spinner spEstado;
    private Button btnRegistrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definimos el layout que vamos a utilizar
        setContentView(R.layout.activity_registro);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        etRepContrasena = (EditText) findViewById(R.id.etRepContrasena);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);
        spEstado = (Spinner) findViewById(R.id.spEstado);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etContrasena.getText().toString().equals(
                        etRepContrasena.getText().toString()
                )) {
                    Usuario item = new Usuario();
                    item.setNombre(etNombre.getText().toString());
                    item.setApellido(etApellido.getText().toString());
                    item.setEstado(spEstado.getSelectedItem().toString());
                    item.setUsuario(etUsuario.getText().toString());
                    /*
                    if(rbMasculino.isChecked()){
                        Masculino
                    }else if(rbFemenino.isChecked()){
                        Femenino
                    }
                    */
                    item.setGenero(
                            rbMasculino.isChecked() ? "Masculino" :
                                    (rbFemenino.isChecked() ? "Femenino" : "")
                    );
                    item.setContrasena(etContrasena.getText().toString());
                    //Agregamos el item a nuestro listado de usuarios
                    Constante.listaUsuarios.add(item);
                    finish();
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "Contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
