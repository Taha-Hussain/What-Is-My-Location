package com.tfs.what_is_my_location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity{

    float lat, lng;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        lat = (float) MainActivity.latitude;
        lng = (float) MainActivity.longitude;
        get_location();


    }

    private void get_location() {



        try {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.google_map_fragment)).getMap();
            MarkerOptions k = new MarkerOptions().position(new LatLng(lat, lng)).title("Ned University").icon(BitmapDescriptorFactory.fromResource(R.drawable.a)).draggable(true).snippet("");
            map.addMarker(k);
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setAllGesturesEnabled(true);
            map.getUiSettings().setCompassEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.getUiSettings().setRotateGesturesEnabled(true);
            map.getUiSettings().setTiltGesturesEnabled(true);

            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat, lng)).zoom(12).build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
