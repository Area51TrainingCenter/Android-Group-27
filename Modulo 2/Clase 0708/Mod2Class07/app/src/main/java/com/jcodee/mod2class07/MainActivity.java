package com.jcodee.mod2class07;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEnviar)
    public void onClick() {

        SafetyWS safetyWS =
                HelperWS
                        .getConfiguration()
                        .create(SafetyWS.class);

        Call<AppResponse> responseCall = safetyWS.app();
        responseCall.enqueue(new Callback<AppResponse>() {
            @Override
            public void onResponse(Call<AppResponse> call, Response<AppResponse> response) {
                ResponseBody responseBody = response.errorBody();
                try {
                    Gson gson = new Gson();
                    AppResponse response1 =
                            gson.fromJson(responseBody.string(), AppResponse.class);

                    tvRespuesta.setText(response1.getErrorMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AppResponse> call, Throwable t) {

            }
        });
    }
}
