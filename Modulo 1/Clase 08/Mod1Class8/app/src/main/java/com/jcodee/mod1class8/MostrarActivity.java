package com.jcodee.mod1class8;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcodee.mod1class8.adapters.FotoAdapter;

public class MostrarActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        adapter = new FotoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }
}
