package com.jcodee.mod3class3.events;

import android.view.View;

/**
 * Created by johannfjs on 20/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
