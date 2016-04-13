package br.com.wiltencirdg.ratetattoo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.android.ratetattoo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private GetStudios studios;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        studios = (GetStudios) getIntent().getSerializableExtra("studios");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        LatLng latlng = new LatLng(studios.getLat(), studios.getLng());
        mMap.addMarker(new MarkerOptions().position(latlng).title(studios.getName()));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(studios.getLat(), studios.getLng()))
                .zoom(18)
                .tilt(0)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
