package com.jcodee.mod1class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {
    //Variables que reciben el valor del componente del diseño
    private EditText etNombre;
    private Button btnProcesar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //Asignamos el componente a la variable
        etNombre = (EditText) findViewById(R.id.etNombre);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        tvResultado.setText("Hola Johann");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

        //Creamos el evento onClick del boton procesar
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtenemos el dato del editText
                String dato = etNombre.getText().toString();
                //Lo ponemos en el textView del resultado
                tvResultado.setText(dato);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(InicioActivity.this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
    /*
        onCreate = el momento de selección de la aplicación de la lista de aplicaciones
        onStart = inicializar componente o variables externas, proceso intermedio de visualización
                   en la pantalla del celular
        onResume = cuando tenemos visible la aplicación en la pantalla del celular
        onPause = se pausa la aplicación al realizar cualquier otra acción externa
        onStop = se detiene la aplicación cuando es cambiada a segundo plano
        onRestart = cuando se retorna a la pantalla de la aplicación
        onDestroy = cuando matamos el proceso de la aplicación
     */
}
