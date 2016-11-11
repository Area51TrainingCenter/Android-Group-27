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
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar.setTag(-1);

        if (getIntent().hasExtra("id")) {
            int id = getIntent().getIntExtra("id", -1);
            if (id > 0) {
                Persona persona = sentencias.obternerPersonaPorId(id);
                etNombreCompleto.setText(persona.getNombreCompleto());
                etEdad.setText(String.valueOf(persona.getEdad()));
                btnRegistrar.setTag(id);
                btnRegistrar.setText("Actualizar");
            }
        }
    }

    @OnClick({R.id.btnRegistrar, R.id.btnListado})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                if ((int) btnRegistrar.getTag() == -1) {
                    registrar();
                } else {
                    actualizar();
                }

                break;
            case R.id.btnListado:

                Intent intent =
                        new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);

                break;
        }
    }

    private void actualizar() {
        String nombrecompleto = etNombreCompleto.getText().toString();
        String edad = etEdad.getText().toString();

        Persona persona = new Persona();
        persona.setNombreCompleto(nombrecompleto);
        persona.setEdad(Integer.parseInt(edad));
        persona.setId((int) btnRegistrar.getTag());
        boolean resultado = sentencias.insertarYActualizarPersona(persona);
        if (resultado) {
            Toast.makeText(this, "Se actualizo correctamente.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ocurrio un error.", Toast.LENGTH_SHORT).show();
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
