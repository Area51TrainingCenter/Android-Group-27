package com.jcodee.mod1class8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.jcodee.mod1class8.adapters.GaleriaAdapter;
import com.jcodee.mod1class8.models.Galeria;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Galeria> lista = new ArrayList<>();
    private GaleriaAdapter adapter;
    private GridView gvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos = (GridView) findViewById(R.id.gvDatos);

        //Precargar datos
        lista.add(new Galeria(lista.size(), "http://www.itespresso.es/wp-content/uploads/2012/08/01_SWdetours.jpg"));
        lista.add(new Galeria(lista.size(), "http://alertaonline.com/wp-content/uploads/473.892x502.jpg"));
        lista.add(new Galeria(lista.size(), "http://i.imgur.com/agMrATf.jpg"));
        lista.add(new Galeria(lista.size(), "https://i.ytimg.com/vi/e59pc3rvWqI/hqdefault.jpg"));
        lista.add(new Galeria(lista.size(), "https://i.ytimg.com/vi/QDbuNM9C9jQ/maxresdefault.jpg"));

        //Vincular la lista con nuestra grilla
        adapter = new GaleriaAdapter(MainActivity.this, lista);
        gvDatos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "posicion->" + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
