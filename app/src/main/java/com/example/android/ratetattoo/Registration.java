package com.example.android.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Registration extends AppCompatActivity {

    private EditText etEmail;
    private EditText etUsuario;
    private EditText etSenha;
    private EditText etConfSenha;
    private Button btnRegistrar;
    private Button btnGoLogin;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
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
                String email = etEmail.getText().toString();
                String name = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();
                String confsenha = etConfSenha.getText().toString();
                if (validateDados(email, name, senha, confsenha)) {
                    if (validateSenha(senha, confsenha)) {
                        backToLogin();
                    }
                }
            }
        });

        btnGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }

    private boolean validateDados(String email, String name, String senha, String confsenha){
        etEmail.setError(null);
        etUsuario.setError(null);
        etSenha.setError(null);
        etConfSenha.setError(null);

        if(email.isEmpty()){
            etEmail.setError("Email vazio.");}
        if(name.isEmpty()){
            etUsuario.setError("Usuário inválido.");}
        if(senha.isEmpty()){
            etSenha.setError("Coloque uma senha.");}
        if(confsenha.isEmpty()) {
            etConfSenha.setError("Confirme a senha.");
            return false;}
        else{
            return true;}
    }

    private void backToLogin(){
        Intent scrlogin = new Intent(Registration.this, Login.class);
        startActivity(scrlogin);
    }
    private boolean validateSenha(String senha, String confsenha){
        if (senha.equals(confsenha)){
            return true;
        }
        else{
            etConfSenha.setError("As senhas não são iguais.");
            return false;
        }

    }
}