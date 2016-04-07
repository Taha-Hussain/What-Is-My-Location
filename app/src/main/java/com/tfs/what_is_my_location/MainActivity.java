package com.tfs.what_is_my_location;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

    //    private GoogleMap mMap;
    TextView tv;
    TextView Cordinates;
    public static double latitude;
    public static double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cordinates = (TextView) findViewById(R.id.Cordinates);
        showMap();
    }

    private void showMap() {
        try {
            setUpMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUpMap() {

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location mylocation = locationManager.getLastKnownLocation(provider);
        latitude = mylocation.getLatitude();
        longitude = mylocation.getLongitude();
        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

        Cordinates.setText("Your Location is - \nLat: " + latitude + "\nLong: " + longitude);
    }

    public void ShowMap_click(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
