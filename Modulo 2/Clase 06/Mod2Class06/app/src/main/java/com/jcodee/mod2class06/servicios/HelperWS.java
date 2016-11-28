package com.jcodee.mod2class06.servicios;

import com.jcodee.mod2class06.response.AddressComponentResponse;
import com.jcodee.mod2class06.response.GeocoderResponse;
import com.jcodee.mod2class06.response.ResultResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johannfjs on 24/11/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HelperWS {
    public static Retrofit getConfiguration() {
        //Armamos la configuración del Retrofit para que pueda consumir
        //nuestro api
        return new Retrofit.Builder()
                //Le ponemos la ruta base del api
                .baseUrl("http://maps.googleapis.com/maps/api/")
                //Adicionamos el resultado que tendrá el web service
                .addConverterFactory(GsonConverterFactory.create())
                //Construye la configuración
                .build();
    }
    //GeocoderResponse  -  BaseReponse
        //ResultResponse
            //AddressComponentResponse
            //GeometryResponse
}
