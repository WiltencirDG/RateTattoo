package com.example.android.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {

    private TextView bvMsg;
    private CardView cvShop1;
    private CardView cvShop2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash);

        setUI();
        setAct();
        getData();
    }

    private void setUI(){
        bvMsg = (TextView) findViewById(R.id.bvMsg);
        cvShop1 = (CardView) findViewById(R.id.cv_shop_1);
        cvShop2 = (CardView) findViewById(R.id.cv_shop_2);
    }

    private void setAct(){
        cvShop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc(R.id.cv_shop_1);
            }
        });

        cvShop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc(R.id.cv_shop_2);
            }
        });

    }

    private void desc(int id){
        Intent intent = new Intent(Dashboard.this, Description.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }

    private void getData(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        String message = "Bem vindo, " + username;
        bvMsg.setText(message);
    }
}







