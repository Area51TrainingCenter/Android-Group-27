package com.jcodee.mod2class1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by johannfjs on 27/10/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    private ManageOpenHelper conexion;

    public SentenciaSQL(Context context) {
        //Inicializamos la conexión a la base de datos
        conexion = new ManageOpenHelper(context);
    }

    //Metodo para la inserción de datos
    public boolean insertarDatos(String nombre, int idGenero) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        boolean resultado = false;

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", nombre);
            contentValues.put("id_genero", idGenero);
            db.insert("tb_datos", null, contentValues);
            resultado = true;
        } catch (Exception e) {

        }
        return resultado;
    }

    public HashMap<Integer, String> obtenerGeneros() {
        //Creamos una lista para obtener todos los valores
        HashMap<Integer, String> lista = new HashMap<>();
        //Creamos la conexión a la base de datos en forma de lectura
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Creación la sentencia para consulta la tabla
        Cursor cursor = db.rawQuery(
                "select id,genero from tb_genero", null);
        //Preguntamos si es que al menos hay un registro
        if (cursor.moveToFirst()) {
            //Recorremos el resultado siempre y cuando haya un siguiente elemento
            do {
                //Agregamos los datos a la lista
                lista.put(
                        //Obtenemos el valor a través del nombre de la columna
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("genero"))
                );
            } while (cursor.moveToNext());
        }
        //retornamos la lista de elementos
        return lista;
    }
}
