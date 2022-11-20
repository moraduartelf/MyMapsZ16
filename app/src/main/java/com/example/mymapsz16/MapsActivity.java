package com.example.mymapsz16;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymapsz16.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button myTypeBtn;
    private Button myBtnHybrid;
    private Button myBtnNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myTypeBtn= findViewById(R.id.btnSatelite);
        //Ahora que cuando lo pulse genere una accion.
        myTypeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        myBtnHybrid= findViewById(R.id.btnHybrid);
        //Ahora que cuando lo pulse genere una accion.
        myBtnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        myBtnNormal= findViewById(R.id.btnNormal);
        myBtnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        miSitio(googleMap);
    }

    public void miSitio(GoogleMap googleMap){
        mMap = googleMap;
        final  LatLng punto1 = new LatLng(6.7040882,-72.7368879);
        mMap.addMarker(new MarkerOptions().position(punto1).title("Mi sitio"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto1));

        final  LatLng punto2 = new LatLng(7.0634735,-73.852611);
        mMap.addMarker(new MarkerOptions().position(punto2).title("Mi sitio"));

        final  LatLng punto3 = new LatLng(10.9838039,-74.8880583);
        mMap.addMarker(new MarkerOptions().position(punto3).title("Mi sitio").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto3));
    }

}