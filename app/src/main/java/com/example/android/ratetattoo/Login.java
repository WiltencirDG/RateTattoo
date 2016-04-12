package com.example.android.ratetattoo;


import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;


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
                final String username = etName.getText().toString();
                final String password = etSenha.getText().toString();

                if (validateData(username, password)) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String username = jsonResponse.getString("username");


                                Intent intent = new Intent(Login.this, Dashboard.class);
                                intent.putExtra("username", username);
                                Login.this.startActivity(intent);


                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage(R.string.logfail)
                                        .setNegativeButton(R.string.tentenov, null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);
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

    private boolean validateData(String username,String password){
        etName.setError(null);
        etSenha.setError(null);

        if(username.isEmpty()){
            etName.setError("Usuário não existe");
            return false;
        }
        if (password.isEmpty()) {
            etSenha.setError("Digite sua senha");
            return false;
        }else{
            return true;
        }
    }
    private void setUI(){
        btLogin = (Button) findViewById(R.id.Login);
        etName = (EditText) findViewById(R.id.EtName);
        etSenha = (EditText) findViewById(R.id.EtSenha);
        tvRegister = (TextView) findViewById(R.id.Register);
    }

}