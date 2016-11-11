package com.jcodee.mod2class2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodee.mod2class2.adapters.PersonaAdapter;
import com.jcodee.mod2class2.entidades.Persona;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends BaseActivity {
    @BindView(R.id.lvLista)
    ListView lvLista;

    private PersonaAdapter adapter;
    private ArrayList<Persona> lista;

    /*
    @BindView(R.id.tvResultado)
    TextView tvResultado;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);

        lista = sentencias.obtenerPersonas();
        adapter = new PersonaAdapter(lista, getApplicationContext());
        lvLista.setAdapter(adapter);


        /*7
        StringBuilder dato = new StringBuilder();
        for (Persona item : lista) {
            dato.append(item.getId());
            dato.append("\n");
            dato.append(item.getNombreCompleto());
            dato.append("\n");
            dato.append(item.getEdad());
            dato.append("\n-----\n");
        }
        tvResultado.setText(dato.toString());*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(ListadoActivity.this);
                builder.setTitle("Mensaje");
                builder.setCancelable(false);
                builder.setMessage("Escoja su opción");
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ListadoActivity.this, MainActivity.class);
                        intent.putExtra("id", lista.get(position).getId());
                        startActivity(intent);

                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Obtener el id de la persona
                        Persona persona = lista.get(position);
                        //Llamar al metodo de bd para eliminar
                        boolean resultado = sentencias.eliminarPersona(persona.getId());
                        if (resultado) {
                            //Volver a cargar los registros
                            lista = sentencias.obtenerPersonas();
                            //Actualizar o notificar que ha habido cambios
                            adapter = new PersonaAdapter(lista, getApplicationContext());
                            lvLista.setAdapter(adapter);
                            //adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(ListadoActivity.this,
                                    "No se pudo eliminar.", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                builder.create().show();

            }
        });
    }
}
