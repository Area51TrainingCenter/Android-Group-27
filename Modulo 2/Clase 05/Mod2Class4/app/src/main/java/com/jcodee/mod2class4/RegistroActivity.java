package com.jcodee.mod2class4;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistroActivity extends BaseActivity {

    @BindView(R.id.etLatitud)
    EditText etLatitud;
    @BindView(R.id.etLongitud)
    EditText etLongitud;
    @BindView(R.id.etDireccion)
    EditText etDireccion;
    @BindView(R.id.etResultado)
    EditText etResultado;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    @Override
    protected void onResume() {
        super.onResume();

        etLatitud.addTextChangedListener(new TextWatcher() {
            //abc
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //ab
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //abc
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();
                obtenerDireccion(latitud, longitud);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //abc
            }
        });

        etLongitud.addTextChangedListener(new TextWatcher() {
            //abc
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //ab
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //abc
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();
                obtenerDireccion(latitud, longitud);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //abc
            }
        });
    }
    //http://maps.googleapis.com/maps/api/geocode/json?latlng=-12.1021498,-77.0276599&sensor=true
    private void obtenerDireccion(String latitud, String longitud) {
        if (latitud.length() > 5 && longitud.length() > 5) {
            Geocoder geocoder =
                    new Geocoder(
                            RegistroActivity.this, Locale.getDefault());
            try {
                List<Address> direcciones =
                        geocoder.getFromLocation(Double.parseDouble(latitud),
                                Double.parseDouble(longitud),
                                1);
                Address direccion = direcciones.get(0);
                etDireccion.setText(direccion.getAddressLine(0));
                etResultado.setText(direccion.getCountryName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.btnRegistrar)
    public void onClick() {
    }
}
