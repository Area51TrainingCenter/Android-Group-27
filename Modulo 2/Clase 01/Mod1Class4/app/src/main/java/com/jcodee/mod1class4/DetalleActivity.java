package com.jcodee.mod1class4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcodee.mod1class4.modelos.Usuario;
import com.jcodee.mod1class4.utils.Constante;

import org.w3c.dom.Text;

/**
 * Created by johannfjs on 18/10/16.
 */

public class DetalleActivity extends AppCompatActivity {
    private TextView tvUsuario;
    private LinearLayout contenedor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        contenedor = (LinearLayout) findViewById(R.id.contenedor);

        //Validamos que el dato que estamos pasando exista
        if (getIntent().hasExtra("posicion")) {
            //Obtenemos el dato
            int posicion = getIntent().getIntExtra("posicion", -1);
            //Si el valor es mayor a cero, significa que es un dato valido
            if (posicion >= 0) {
                //Obtenemos el usuario según el indice
                Usuario usuario = Constante.listaUsuarios.get(posicion);
                tvUsuario.setText(usuario.getUsuario());
                agregarComponente(
                        getResources().getString(R.string.nombre),
                        usuario.getNombre());
                agregarComponente(
                        getResources().getString(R.string.apellido),
                        usuario.getApellido()
                );
                agregarComponente(
                        getResources().getString(R.string.estado),
                        usuario.getEstado()
                );
                agregarComponente(
                        getResources().getString(R.string.genero),
                        usuario.getGenero()
                );
            }
        }
    }

    //Agregar un componente desde codigo JAVA
    private void agregarComponente(String key, String value) {
        //Creamos un LinearLayout de forma horizontal
        LinearLayout llHorizontal = new LinearLayout(DetalleActivity.this);
        //Le agregamos los valores que tendrá en el ancho y alto
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        //Agregamos los valores a nuestro LinearLayout
        llHorizontal.setLayoutParams(layoutParams);

        //Creamos un LinearLayout para el Key
        LinearLayout llKey = new LinearLayout(DetalleActivity.this);
        LinearLayout.LayoutParams llKeyParams =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        llKeyParams.weight = 1;
        llKey.setLayoutParams(llKeyParams);
        llKey.setOrientation(LinearLayout.HORIZONTAL);
        llHorizontal.addView(llKey);

        //Creamos un TextView para el Key
        TextView tvKey = new TextView(DetalleActivity.this);
        LinearLayout.LayoutParams tvKeyParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        //Indicamos que la posición del TextView va a estar en el medio
        tvKeyParams.gravity = Gravity.CENTER;
        tvKeyParams.setMargins(0, 0, 20, 0);
        //Seteamos los datos
        tvKey.setLayoutParams(tvKeyParams);
        tvKey.setTextColor(Color.BLACK);
        //tvKey.setInputType(InputType.TYPE_CLASS_TEXT);
        tvKey.setText(key);
        //Agregamos el TextView a nuestro LinearLayout
        llKey.addView(tvKey);


        //Creamos un LinearLayout para el Value
        LinearLayout llValue = new LinearLayout(DetalleActivity.this);
        LinearLayout.LayoutParams llValueParams =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        llValueParams.weight = 2;
        llValue.setLayoutParams(llValueParams);
        llHorizontal.addView(llValue);

        //Creamos un TextView para el Value
        TextView tvValue = new TextView(DetalleActivity.this);
        LinearLayout.LayoutParams tvValueParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        tvValueParams.gravity = Gravity.CENTER;
        tvValueParams.setMargins(0, 0, 20, 0);
        tvValue.setLayoutParams(tvValueParams);
        tvValue.setTextColor(Color.BLACK);
        //tvValue.setInputType(InputType.TYPE_CLASS_TEXT);
        tvValue.setText(value);
        llValue.addView(tvValue);

        //Agregamos el LinearLayout creado a nuestro LinearLayout principal
        contenedor.addView(llHorizontal);
    }
}
