package br.com.wiltencirdg.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.ratetattoo.R;


public class Description extends AppCompatActivity{
    private ImageView ivImage;
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvPhone;
    private GetStudios studios;
    private Button btnMap;
    private ImageView ivToolbar;
    private Button btnVote;
    private RatingBar ratebar;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        studios = (GetStudios)getIntent().getSerializableExtra("studio");
        setUI();
        setData(studios);
        setMap();
        setToolbar();
    }

    private void setUI(){
        ivImage = (ImageView) findViewById(R.id.iv_shop);
        tvName = (TextView) findViewById(R.id.tv_n_shop);
        tvAddress = (TextView) findViewById(R.id.tv_a_shop);
        tvPhone = (TextView) findViewById(R.id.tv_p_shop);
        btnMap = (Button) findViewById(R.id.btn_map);
        btnVote = (Button) findViewById(R.id.btn_votar);
        ratebar = (RatingBar) findViewById(R.id.ratebar);
    }

    private void setToolbar(){
        ivToolbar = (ImageView) findViewById(R.id.ic_tool);

        ivToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void setData(GetStudios studios){
        ivImage.setImageResource(studios.getIdImage());
        tvName.setText(studios.getName());
        tvAddress.setText(studios.getAddress());
        tvPhone.setText(studios.getPhone());
    }

    private void setMap(){
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Maps(studios);
            }
        });
    }

    private void Maps(GetStudios studios){
        Intent intent = new Intent(Description.this, Maps.class);
        intent.putExtra("studios", studios);
        startActivity(intent);
    }

}
