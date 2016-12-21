package com.jcodee.mod3class3.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Reusable {
    public static boolean existeConexion(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)
                        context.getSystemService(
                                Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =
                connectivityManager.getActiveNetworkInfo();
        return networkInfo != null &&
                networkInfo.isConnected() &&
                networkInfo.isAvailable();
    }
}
