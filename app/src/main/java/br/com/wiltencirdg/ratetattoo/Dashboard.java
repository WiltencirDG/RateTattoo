package br.com.wiltencirdg.ratetattoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.ratetattoo.R;

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
        studio.setLat(-25.511631);
        studio.setLng(-49.327682);
        studiosTemp.add(studio);

        //Studio2
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_2));
        studio.setAddress(getString(R.string.e_shop_2));
        studio.setIdImage(R.drawable.img_shop_2);
        studio.setPhone(R.string.p_shop_2);
        studio.setLat(-25.508790);
        studio.setLng(-49.325243);
        studiosTemp.add(studio);

        //Studio3
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_3));
        studio.setAddress(getString(R.string.e_shop_3));
        studio.setIdImage(R.drawable.img_shop_3);
        studio.setPhone(R.string.p_shop_3);
        studio.setLat(-25.537656);
        studio.setLng(-49.276187);
        studiosTemp.add(studio);

        //Studio4
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_4));
        studio.setAddress(getString(R.string.e_shop_4));
        studio.setIdImage(R.drawable.img_shop_4);
        studio.setPhone(R.string.p_shop_4);
        studio.setLat(-25.446405);
        studio.setLng(-49.276062);
        studiosTemp.add(studio);

        //Studio5
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_5));
        studio.setAddress(getString(R.string.e_shop_5));
        studio.setIdImage(R.drawable.img_shop_5);
        studio.setPhone(R.string.p_shop_5);
        studio.setLat(-25.435630);
        studio.setLng(-49.277428);
        studiosTemp.add(studio);

        //Studio6
        studio = new GetStudios();
        studio.setName(getString(R.string.n_shop_6));
        studio.setAddress(getString(R.string.e_shop_6));
        studio.setIdImage(R.drawable.img_shop_6);
        studio.setPhone(R.string.p_shop_6);
        studio.setLat(-25.536702);
        studio.setLng(-49.273882);
        studiosTemp.add(studio);

        return studiosTemp;
    }

}







