package com.jcodee.mod2class07;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcodee.mod2class07.request.AppRequest;
import com.jcodee.mod2class07.request.SafetyRequest;
import com.jcodee.mod2class07.response.AppResponse;
import com.jcodee.mod2class07.services.HelperWS;
import com.jcodee.mod2class07.services.SafetyWS;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnEnviar)
    Button btnEnviar;
    @BindView(R.id.tvRespuesta)
    TextView tvRespuesta;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etDescription)
    EditText etDescription;
    @BindView(R.id.etWebsite)
    EditText etWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SafetyWS safetyWS =
                HelperWS.getConfiguration().create(SafetyWS.class);
        Call<ZzyResponse> resultado = safetyWS.verificar("zzzy");
        resultado.enqueue(new Callback<ZzyResponse>() {
            @Override
            public void onResponse(Call<ZzyResponse> call, Response<ZzyResponse> response) {
                ZzyResponse resultadoFinal=response.body();
                resultadoFinal.getResults().getConsumerKey();
            }

            @Override
            public void onFailure(Call<ZzyResponse> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btnEnviar)
    public void onClick() {
        String name = etName.getText().toString(),
                description = etDescription.getText().toString(),
                website = etWebsite.getText().toString();

        //inicializamos el gson para poder parsear el objeto
        Gson gsonParse = new Gson();
        //Creamos una variable de tipo safetyRequest
        SafetyRequest safetyRequest = new SafetyRequest();
        //cargamos los datos que se enviaran al ws
        AppRequest appRequest = new AppRequest();
        appRequest.setName(name);
        appRequest.setDescription(description);
        appRequest.setWebSite(website);
        appRequest.setApiProductId(1);
        appRequest.setAppType(1);
        appRequest.setAccessTokenExpireTime(20);
        appRequest.setRefreshTokenTime(120);
        safetyRequest.setApp(appRequest);
        //Parseamos la variable safetyRequest a un json
        String resultado = gsonParse.toJson(safetyRequest);
        //Imprimiendo el resultado en la consola
        Log.d("TAG", resultado);

        SafetyWS safetyWS =
                HelperWS
                        .getConfiguration()
                        .create(SafetyWS.class);

        Call<AppResponse> responseCall = safetyWS.app(safetyRequest);
        responseCall.enqueue(new Callback<AppResponse>() {
            @Override
            public void onResponse(Call<AppResponse> call, Response<AppResponse> response) {
                if (response.code() == 201 ||
                        response.code() == 200) {
                    tvRespuesta.setText("->" + response.code());
                } else {
                    ResponseBody responseBody = response.errorBody();
                    try {
                        Gson gson = new Gson();
                        AppResponse response1 =
                                gson.fromJson(responseBody.string(), AppResponse.class);

                        if (response1 != null)
                            tvRespuesta.setText(response1.getErrorMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AppResponse> call, Throwable t) {
                Log.d("TAG", "Se cayo->" + t.getMessage());
            }
        });
    }
}
