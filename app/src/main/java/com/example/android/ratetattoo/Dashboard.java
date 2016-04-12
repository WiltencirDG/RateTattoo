package com.example.android.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.android.ratetattoo.GetStudios;
import com.example.android.ratetattoo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Dashboard extends AppCompatActivity {

    private TextView bvMsg;
    private RecyclerView rvPlaces;
    private List<GetStudios> studios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash);

        String username  = getIntent().getStringExtra("username");
        setUI();
        setToolbar(username);
        studios = getStudios();
        setRecyclerView();
    }

    private void setUI(){
        rvPlaces = (RecyclerView) findViewById(R.id.rv_studios);
        bvMsg = (TextView) findViewById(R.id.bvMsg);
    }

    private void setToolbar(String username){
        bvMsg.setText(getString(R.string.bemvindo) + " " + username);
    }

    private void setRecyclerView(){
        rvPlaces.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPlaces.setLayoutManager(mLayoutManager);

        Adapter mAdapter = new Adapter(studios);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDescription(studios.get(rvPlaces.getChildLayoutPosition(view)));
            }
        });

        rvPlaces.setAdapter(mAdapter);
        rvPlaces.setItemAnimator(new DefaultItemAnimator());
    }

    private void goToDescription(GetStudios studio){
        Intent intent = new Intent(Dashboard.this, Description.class);
        intent.putExtra("studio", studio);
        startActivity(intent);
    }

    private List<GetStudios> getStudios(){

        List<GetStudios> studiosTemp = new ArrayList<>();
        GetStudios studio = new GetStudios();

        //Studio1
        studio.setName(getString(R.string.n_shop_1));
        studio.setAddress(getString(R.string.e_shop_1));
        studio.setIdImage(R.drawable.img_shop_1);
        studio.setPhone(R.string.p_shop_1);
        studio.setLat(-25.511525);
        studio.setLng(-49.327670);
        studiosTemp.add(studio);

        //Studio2
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_2));
        studio.setAddress(getString(R.string.e_shop_2));
        studio.setIdImage(R.drawable.img_shop_2);
        studio.setPhone(R.string.p_shop_2);
        studio.setLat(-25.508585);
        studio.setLng(-49.325264);
        studiosTemp.add(studio);

        return studiosTemp;
    }

}







