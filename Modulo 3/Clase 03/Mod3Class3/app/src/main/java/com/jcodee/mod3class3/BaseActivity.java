package com.jcodee.mod3class3;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.jcodee.mod3class3.database.Querys;

import butterknife.ButterKnife;
import retrofit2.http.Query;

/**
 * Created by johannfjs on 15/12/16.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Querys querys;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        querys = new Querys();
    }
}
