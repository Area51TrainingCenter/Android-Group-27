package com.jcodee.mod2class2.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johannfjs on 8/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

//RealmObject asigna a la clase la propiedad de ser una tabla de bd
public class Persona extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombreCompleto;
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
