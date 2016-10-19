package com.jcodee.mod1class4.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.jcodee.mod1class4.R;

/**
 * Created by johannfjs on 13/10/16.
 */

public class TextViewCustom extends TextView {
    public TextViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewCustom(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        //Cambiar el tipo de letra
        //Creamos el tipo de letra según la ruta del archivo
        Typeface typeface =
                Typeface.createFromAsset(
                        context.getAssets(), "fonts/Pacifico.ttf");
        //Cambiamos el texto
        setTypeface(typeface);

        //El TextView siempre cargue de color negro
        setTextColor(Color.BLUE);
    }
}
