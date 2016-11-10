package com.jcodee.mod2class2.aplicacion;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by johannfjs on 8/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        //Creamos configuración de Realm (Base de datos interna)
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder()
                        //Versión de la base de datos
                        .schemaVersion(1)
                        //Nombre de la base de datos
                        .name("mod2class2.realm")
                        //Si queremos tener data pre-cargada
                        .initialData(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                //Creamos data pre-cargada
                            }
                        })
                        .build();
        //Cambiamos la configuración de la base de datos
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
