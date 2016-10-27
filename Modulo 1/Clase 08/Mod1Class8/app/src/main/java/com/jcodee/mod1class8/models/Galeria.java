package com.jcodee.mod1class8.models;

/**
 * Created by johannfjs on 25/10/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Galeria {

    private int id;
    private String ruta;

    public Galeria(int id, String ruta) {
        this.id = id;
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
