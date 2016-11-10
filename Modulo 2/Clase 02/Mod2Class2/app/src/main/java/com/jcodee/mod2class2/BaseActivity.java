package com.jcodee.mod2class2;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jcodee.mod2class2.database.Sentencias;

import butterknife.ButterKnife;

/**
 * Created by johannfjs on 8/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class BaseActivity extends AppCompatActivity {
    //Creamos una variable para la conexión a la base de datos
    public Sentencias sentencias;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        //Inicializamos el ButterKnife para que vincule los componentes
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Incializando nuestra conexión a la bd
        sentencias = new Sentencias();

        super.onCreate(savedInstanceState);
    }
}
