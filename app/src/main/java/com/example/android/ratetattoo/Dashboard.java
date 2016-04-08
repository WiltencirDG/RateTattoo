package com.example.android.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    private CardView cvShop1;
    private CardView cvShop2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash);

        setUI();
        setAct();
    }

    private void setUI(){
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
}







