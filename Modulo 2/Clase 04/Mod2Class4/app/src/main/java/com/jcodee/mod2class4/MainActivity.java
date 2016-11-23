package com.jcodee.mod2class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    public GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                MainActivity.this.googleMap = googleMap;
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.setTrafficEnabled(true);

                LatLng latLng = new LatLng(-21.1234567, -71);

                for (int i = 0; i < 10; i++) {
                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(
                                    (-21.1234567 + (10 * i)),
                                    (-71 + i)))
                            .title("Titulo")
                            .snippet("Descripcón"));
                }
                googleMap.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(latLng, 12));
            }
        });
    }
}
