package com.jcodee.mod2class1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by johannfjs on 27/10/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, "mod2class1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_genero (" +
                "id integer primary key autoincrement," +
                "genero text)");
        db.execSQL("create table tb_datos (" +
                "id integer primary key autoincrement," +
                "id_genero integer," +
                "nombre text," +
                "foreign key (id_genero) references tb_genero(id))");

        db.execSQL("insert into tb_genero (genero) " +
                "values ('Masculino'),('Femenino')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion <= 2) {
            //Agregar nuevas tablas
        }
    }
}
