package com.jcodee.mod1class4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod1class4.modelos.Usuario;
import com.jcodee.mod1class4.utils.Constante;

public class MainActivity extends AppCompatActivity/* implements View.OnClickListener*/ {
    private EditText etUsuario, etContrasena;
    private Button btnIniciarSesion, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Declaramos una variable para verificar si existe usuario
                boolean existeUsuario = false;
                //Recorremos la lista de usuarios para poder ver si se
                //encuentra registrado el usuario que se está logeando
                String nombreCompleto = "";
                for (Usuario usuario : Constante.listaUsuarios) {
                    if (usuario.getUsuario()
                            .equals(etUsuario.getText().toString()) &&
                            usuario.getContrasena()
                                    .equals(etContrasena.getText().toString())) {
                        existeUsuario = true;
                        nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
                    }
                }

                if (existeUsuario) {
                    Intent intent = new Intent(
                            MainActivity.this, ListadoActivity.class);
                    //Creamos un bundle para poder pasar las variables
                    Bundle bundle = new Bundle();
                    //Agregamos las variables a enviar
                    bundle.putString("nombreCompleto", nombreCompleto);
                    bundle.putString("variable2","valor2");
                    //Agregamos el bundle con las variables al intent
                    intent.putExtras(bundle);
                    //Ejecutamos la acción del intent y enviamos los datos del bundle
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Usuario y/o Contraseña incorrectos.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    /*
    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.btnIniciarSesion)) {
            //Ejecución del método
        }
    }

    public void iniciarSesion(View view) {

    }
    */
}
