package com.example.android.ratetattoo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    private TextView tvRegister;
    private Button btLogin;
    private EditText etName;
    private EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setUI();
        Act();
    }

    private void Act(){
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();

                if (validateName(name)) {
                    logado(name);
                }

            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent register = new Intent(Login.this, Registration.class);
                startActivity(register);
            }

        });

    }

    private boolean validateName(String name){
        etName.setError(null);

        if(name.isEmpty()){
            etName.setError("Usuário não existe");
            return false;
        }
        return true;
    }
    private void setUI(){
        btLogin = (Button) findViewById(R.id.Login);
        etName = (EditText) findViewById(R.id.EtName);
        etSenha = (EditText) findViewById(R.id.EtSenha);
        tvRegister = (TextView) findViewById(R.id.Register);
    }

    private void logado(String name){
        Intent logdash = new Intent(Login.this, Dashboard.class);
        logdash.putExtra("name", name);
        startActivity(logdash);
    }

}