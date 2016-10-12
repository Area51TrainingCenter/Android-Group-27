package com.jcodee.mod1class4.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 11/10/16.
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializando la librería de FrescoLib
        //Librería para manejo de imagenes (locales, internet)
        Fresco.initialize(getApplicationContext());
    }
}
