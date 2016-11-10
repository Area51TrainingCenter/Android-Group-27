package com.jcodee.mod2class2.database;

import com.jcodee.mod2class2.entidades.Persona;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 8/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Sentencias {
    public boolean insertarYActualizarPersona(Persona persona) {
        //Obtenemos la instancia de la base de datos
        Realm realm = Realm.getDefaultInstance();
        try {
            //Iniciamos una transacción
            realm.beginTransaction();

            //Insertamos a la base de datos
            realm.copyToRealmOrUpdate(persona);

            /*
            //Otra forma de registrar
            realm.copyToRealm(persona);

            //Otra forma de registrar
            Persona persona1=realm.createObject(Persona.class);
            persona1.setId(persona.getId());
            persona1.setEdad(persona.getEdad());
            persona1.setNombreCompleto(persona.getNombreCompleto());
            */

            //Ejecutamos todos los cambios que se han realizado en
            //la base de datos
            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            //Si por algún motivo se cae, vamos a hacer un rollback
            realm.cancelTransaction();
        }
        return false;
    }

    public int obtenerPersonaId() {
        //Creamos la instancia de conexión a la bd
        Realm realm = Realm.getDefaultInstance();
        //Consultamos la cantidad de registros que hay y
        //cual ha sido el máximo ID
        Number number = realm.where(Persona.class).max("id");
        //Si el codigo es null, ponemos por defecto 1
        //Pero si trae resultado, obtenemos el codigo entero
        return number == null ? 1 : (number.intValue() + 1);
    }

    public ArrayList<Persona> obtenerPersonas() {
        //Obtenemos la conexión a la base de datos
        Realm realm = Realm.getDefaultInstance();
        //Obtenemos todos los registros de la tabla Persona
        RealmResults<Persona> personas =
                realm.where(Persona.class).findAll();
        //Creamos una variable de lista de personas
        ArrayList<Persona> lista = new ArrayList<>();
        //Iteramos para obtener los datos
        for (Persona item : personas) {
            lista.add(item);
        }
        //Retornamos la lista con las personas obtenidas de la bd
        return lista;
    }
}
