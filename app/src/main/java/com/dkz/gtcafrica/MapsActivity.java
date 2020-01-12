package com.dkz.gtcafrica;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.dkz.gtcafrica.model.MapAddress;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        MapAddress durban= new MapAddress("Gordon Rajapogal: Durban Teen Challenge","Afrique du Sud","Durban","Newlands East",-29.777830,30.988298,"5/7 Marlin Grov Newlands East Durban",0,"0833448430");
        MapAddress nigeria= new MapAddress("BETLAADA ADULT & TEEN CHALLENGE","Nigeria","Ibadan","",7.323658, 3.898848,"42A UNIQUE ESTATE, SANYO , IBADAN, NIGERIA",0,"+234-810-508-7705");
        MapAddress ghana= new MapAddress("Teen Challenge, Ghana.","Ghana","Koforidua","Eastern Region",6.065691, -0.252336,"Hse No. 193A, Adweso, Koforidua, Eastern Region, Ghana.",0,"+233243841230");
        MapAddress nairo= new MapAddress("Teen Challenge Kenya","Kenya","Nairobi","Kiambu",-1.197566, 36.845074,"Mushroom Rd, Kiambu, Kenya",0,"+254 722 410751");
        MapAddress nigeria_jos= new MapAddress("Teen Challenge Jos, Nigeria","Nigeria","Jos","Plateu State",9.897248, 8.896680," No 74 Liberty Boulevard Gwarandok, Jos Plateau State, Nigeria",0,"");
        mMap.addMarker(new MarkerOptions().position(new LatLng(durban.getLat(),durban.getLng())).title(durban.getOrganisation()));
        mMap.addMarker(new MarkerOptions().position(new LatLng(nigeria.getLat(),nigeria.getLng())).title(nigeria.getOrganisation()));
        mMap.addMarker(new MarkerOptions().position(new LatLng(ghana.getLat(),ghana.getLng())).title(ghana.getOrganisation()));
        mMap.addMarker(new MarkerOptions().position(new LatLng(nairo.getLat(),nairo.getLng())).title(nairo.getOrganisation()));
        mMap.addMarker(new MarkerOptions().position(new LatLng(nigeria_jos.getLat(),nigeria_jos.getLng())).title(nigeria_jos.getOrganisation()));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(durban.getLat(), durban.getLng())));
    }
}
