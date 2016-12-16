package com.jcodee.mod3class3.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class TextViewUno extends TextView {
    public TextViewUno(Context context) {
        super(context);
        init(context);
    }

    public TextViewUno(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewUno(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface =
                Typeface.createFromAsset(context.getAssets(), "fonts/Pacifico.ttf");
        setTypeface(typeface);
    }
}
