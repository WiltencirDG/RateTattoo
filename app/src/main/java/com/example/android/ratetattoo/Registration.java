package com.example.android.ratetattoo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Registration extends AppCompatActivity {

    private EditText etEmail;
    private EditText etUsuario;
    private EditText etSenha;
    private EditText etConfSenha;
    private Button btnRegistrar;
    private Button btnGoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setUI();
        Act();
    }

    private void setUI(){
        etEmail = (EditText) findViewById(R.id.Email);
        etUsuario = (EditText) findViewById(R.id.Usuario);
        etSenha = (EditText) findViewById(R.id.Senha);
        etConfSenha = (EditText) findViewById(R.id.ConfSenha);
        btnRegistrar = (Button) findViewById(R.id.RegButton);
        btnGoLogin = (Button) findViewById(R.id.LogButton);
    }

    private void Act(){
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etEmail.getText().toString();
                final String username = etUsuario.getText().toString();
                final String senha = etSenha.getText().toString();
                final String confsenha = etConfSenha.getText().toString();
                if (validateDados(email, username, senha, confsenha))
                    if (validateSenha(senha, confsenha)) {

                        final Response.Listener<String> responseListener = new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");

                                    if (success) {
                                        Intent intent = new Intent(Registration.this, Login.class);
                                        Registration.this.startActivity(intent);

                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                                        builder.setMessage(R.string.regfail)
                                                .setNegativeButton(R.string.tentenov, null)
                                                .create()
                                                .show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        RegisterRequest registerRequest = new RegisterRequest(username, email, senha, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(Registration.this);
                        queue.add(registerRequest);
                    }
            }
        });

        btnGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                Registration.this.startActivity(intent);
            }
        });
    }

    private boolean validateDados(String email, String username, String senha, String confsenha){
        etEmail.setError(null);
        etUsuario.setError(null);
        etSenha.setError(null);
        etConfSenha.setError(null);

        if(email.isEmpty()){
            etEmail.setError("Email vazio");}
        if(username.isEmpty()){
            etUsuario.setError("Usuário inválido.");}
        if(senha.isEmpty()){
            etSenha.setError("Coloque uma senha.");}
        if(confsenha.isEmpty()) {
            etConfSenha.setError("Confirme a senha.");
            return false;}
        else{
            return true;}
    }

    private boolean validateSenha(String senha, String confsenha){
        if (senha.equals(confsenha)){
            return true;
        }else{
            etConfSenha.setError("As senhas não são iguais.");
            return false;
        }

    }


}