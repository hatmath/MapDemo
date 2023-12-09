
package com.hatmath.mapdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;
    double longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Récupération des valeurs de longitude et latitude de l'Intent
        longitude = getIntent().getDoubleExtra("LONGITUDE", -71.207981); // Valeur par défaut si pas de longitude
        latitude = getIntent().getDoubleExtra("LATITUDE", 46.813878); // Valeur par défaut si pas de latitude

        map = findViewById(R.id.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap = googleMap;

        // Utilisation des valeurs récupérées pour définir la position de la carte
        LatLng position = new LatLng(latitude, longitude);
        this.gMap.addMarker(new MarkerOptions().position(position).title("Marker personnalisé"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }
}