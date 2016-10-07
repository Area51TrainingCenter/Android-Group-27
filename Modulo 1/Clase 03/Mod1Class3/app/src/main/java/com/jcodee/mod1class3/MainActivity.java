package com.jcodee.mod1class3;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private Spinner spGenero;
    private EditText etEdad;
    private Spinner spEstadoCivil;
    private Button btnProcesar;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        etEdad = (EditText) findViewById(R.id.etEdad);
        spEstadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //1. El contexto de la aplicación
        //2. El diseño que va a manejar los item's
        //3. La lista de opciones que se van a visualizar
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.estado_civil)
        );
        //Cambiamos la estructura del Spinner por la que nosotros hemos asignado
        spEstadoCivil.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();

                //Cambiamos de pantalla
                Intent intent = new Intent(MainActivity.this, DosActivity.class);

                //Enviar datos a través del intent
                intent.putExtra("nombre", nombre);

                //Ejecutamos el cambio de pantalla
                startActivity(intent);
                //Elimina del historico la pantalla actual
                //finish();

            }
        });

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtenemos los datos de nuestros componentes
                String nombre = etNombre.getText().toString();
                String genero = spGenero.getSelectedItem().toString();
                String edad = etEdad.getText().toString();
                String estadoCivil = spEstadoCivil.getSelectedItem().toString();

                //Validamos los datos
                if (nombre.isEmpty() || genero.isEmpty() ||
                        edad.isEmpty() || estadoCivil.isEmpty()) {

                    //Si es que algún dato está vacío enviamos un mensaje
                    //getApplicationContext()
                    Toast.makeText(MainActivity.this,
                            "Debe de completar todos los datos.",
                            Toast.LENGTH_SHORT).show();

                } else {
                    //Enviamos un mensaje con todos los datos capturados
                    Toast toast = Toast.makeText(
                            MainActivity.this,
                            Html.fromHtml(
                                    "<b><font size=\"20\">" +
                                            "Nombre -> " + nombre + "\n" +
                                            "Genero -> " + genero + "\n" +
                                            "Edad -> " + edad + "\n" +
                                            "Estado Civil -> " + estadoCivil +
                                            "</font></b>"
                            ),
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();

                    //Mensaje de tipo dialogo
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Mensaje");
                    builder.setMessage(
                            "Nombre -> " + nombre + "\n" +
                                    "Genero -> " + genero + "\n" +
                                    "Edad -> " + edad + "\n" +
                                    "Estado Civil -> " + estadoCivil);
                    //Construimos el mensaje y lo mostramos
                    builder.create().show();
                }

            }
        });
    }
}
