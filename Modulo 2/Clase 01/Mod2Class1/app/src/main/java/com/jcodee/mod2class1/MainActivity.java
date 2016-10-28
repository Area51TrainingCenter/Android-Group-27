package com.jcodee.mod2class1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.spGenero)
    Spinner spGenero;
    @BindView(R.id.btnGrabar)
    Button btnGrabar;
    @BindView(R.id.btnListado)
    Button btnListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnGrabar, R.id.btnListado})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGrabar:
                break;
            case R.id.btnListado:

                //Plug-in Zelezny
                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);

                break;
        }
    }
}
