package com.jcodee.mod2class2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class2.entidades.Persona;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.etNombreCompleto)
    EditText etNombreCompleto;
    @BindView(R.id.etEdad)
    EditText etEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.btnRegistrar, R.id.btnListado})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                registrar();

                break;
            case R.id.btnListado:

                Intent intent =
                        new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void registrar() {

        //Validamos que los campos esten cargados
        String nombrecompleto = etNombreCompleto.getText().toString();
        String edad = etEdad.getText().toString();
        if (nombrecompleto.isEmpty() || edad.isEmpty()) {
            Toast.makeText(this,
                    "Todos los campos deben de estar llenos.",
                    Toast.LENGTH_SHORT).show();
        } else {
            //Registramos en nuestra BD los datos
            Persona persona = new Persona();
            persona.setNombreCompleto(nombrecompleto);
            persona.setEdad(Integer.parseInt(edad));
            persona.setId(sentencias.obtenerPersonaId());

            //Enviamos los datos a la BD
            boolean resultado = sentencias.insertarYActualizarPersona(persona);
            if (resultado) {
                Toast.makeText(this,
                        "Se registro correctamente.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Ocurrio un error.",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
