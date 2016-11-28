package com.jcodee.mod2class06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodee.mod2class06.response.AddressComponentResponse;
import com.jcodee.mod2class06.response.GeocoderResponse;
import com.jcodee.mod2class06.response.ResultResponse;
import com.jcodee.mod2class06.servicios.GeocoderWS;
import com.jcodee.mod2class06.servicios.HelperWS;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnEjecutar)
    Button btnEjecutar;
    @BindView(R.id.tvTexto1)
    TextView tvTexto1;
    @BindView(R.id.tvTexto2)
    TextView tvTexto2;
    @BindView(R.id.tvTexto3)
    TextView tvTexto3;
    @BindView(R.id.tvTexto4)
    TextView tvTexto4;
    @BindView(R.id.tvTexto5)
    TextView tvTexto5;
    @BindView(R.id.tvTexto6)
    TextView tvTexto6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeocoderWS geocoderWS =
                        HelperWS.getConfiguration().create(GeocoderWS.class);
                Call<GeocoderResponse> respuesta = geocoderWS.geocoder();
                respuesta.enqueue(new Callback<GeocoderResponse>() {
                    @Override
                    public void onResponse(Call<GeocoderResponse> call, Response<GeocoderResponse> response) {
                        GeocoderResponse rsp = response.body();
                        if (rsp.getResults() != null) {
                            for (ResultResponse resultResponse : rsp.getResults()) {
                                if (resultResponse.getAddressComponents() != null) {
                                    int contador = 0;
                                    for (AddressComponentResponse addressComponentResponse
                                            : resultResponse.getAddressComponents()) {
                                        String dato = addressComponentResponse.getLongName();
                                        switch (contador) {
                                            case 0:
                                                tvTexto1.setText(dato);
                                                break;
                                            case 1:
                                                tvTexto2.setText(dato);
                                                break;
                                            case 2:
                                                tvTexto3.setText(dato);
                                                break;
                                            case 3:
                                                tvTexto4.setText(dato);
                                                break;
                                            case 4:
                                                tvTexto5.setText(dato);
                                                break;
                                            case 5:
                                                tvTexto6.setText(dato);
                                                break;
                                        }
                                        contador++;
                                    }
                                }
                            }
                        }

                        Toast.makeText(MainActivity.this, "Obtuvo datos.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<GeocoderResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}
