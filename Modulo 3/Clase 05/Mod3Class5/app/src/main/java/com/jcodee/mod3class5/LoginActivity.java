package com.jcodee.mod3class5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etCorreo)
    EditText etCorreo;
    @BindView(R.id.etContrasenia)
    EditText etContrasenia;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    @OnClick({R.id.btnLogin, R.id.btnRegistrar, R.id.btnOlvidar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                final String usuario = etCorreo.getText().toString();
                String contrasenia = etContrasenia.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(usuario, contrasenia)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Se logueo " + usuario, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
            case R.id.btnRegistrar:

                etCorreo.setText("");
                etContrasenia.setText("");
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);

                break;
            case R.id.btnOlvidar:

                Intent intent2 = new Intent(LoginActivity.this, RecuperarActivity.class);
                startActivity(intent2);

                break;
        }
    }
}
