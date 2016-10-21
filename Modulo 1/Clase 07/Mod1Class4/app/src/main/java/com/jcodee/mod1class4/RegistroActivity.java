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

        btnRegistrar.setTag(-1);

        if (getIntent().hasExtra("accion")) {
            int posicion = getIntent().getIntExtra("posicion", -1);
            int accion = getIntent().getIntExtra("accion", -1);

            Usuario usuario = Constante.listaUsuarios.get(posicion);
            etUsuario.setText(usuario.getUsuario());
            etApellido.setText(usuario.getApellido());
            etNombre.setText(usuario.getNombre());
            int con = 0;
            for (String texto : getResources().getStringArray(R.array.estado)) {
                if (texto.equals(usuario.getEstado())) {
                    spEstado.setSelection(con);
                    break;
                }
                con++;
            }
            if (usuario.getGenero().equals("Masculino")) {
                rbMasculino.setChecked(true);
            } else {
                rbFemenino.setChecked(true);
            }

            switch (accion) {
                case 1:
                    btnRegistrar.setText("Modificar");
                    btnRegistrar.setTag(posicion);
                    break;
                case 2:
                    etNombre.setEnabled(false);
                    etApellido.setEnabled(false);
                    etContrasena.setEnabled(false);
                    etRepContrasena.setEnabled(false);
                    etUsuario.setEnabled(false);
                    spEstado.setEnabled(false);
                    rbMasculino.setEnabled(false);
                    rbFemenino.setEnabled(false);
                    /*
                    VISIBLE = es visible al usuario
                    INVISIBLE = no es visible al usuario, pero ocupa un lugar en la pantalla
                    GONE = no es visible al usuario, y no ocupa un lugar en la pantalla
                    */
                    btnRegistrar.setVisibility(View.GONE);
                    break;
            }
        }
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

                    //Obtenemos el dato del boton, para saber si se está registrando
                    //o se va a actualizar
                    //si es -1, es un registro
                    if ((int) btnRegistrar.getTag() == -1) {
                        //Agregamos el item a nuestro listado de usuarios
                        Constante.listaUsuarios.add(item);
                    } else {
                        //Si es mayor o igual a 0 es un actualizar
                        int posicion = (int) btnRegistrar.getTag();
                        Constante.listaUsuarios.get(posicion).setUsuario(item.getUsuario());
                        Constante.listaUsuarios.get(posicion).setNombre(item.getNombre());
                        Constante.listaUsuarios.get(posicion).setApellido(item.getApellido());
                        Constante.listaUsuarios.get(posicion).setGenero(item.getGenero());
                        Constante.listaUsuarios.get(posicion).setEstado(item.getEstado());
                        Constante.listaUsuarios.get(posicion).setContrasena(item.getContrasena());

                    }
                    finish();
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "Contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
