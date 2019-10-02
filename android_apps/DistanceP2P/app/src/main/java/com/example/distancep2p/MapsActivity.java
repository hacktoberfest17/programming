package com.example.distancep2p;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.maps.android.SphericalUtil;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    EditText latitude1, longitude1, latitude2, longitude2;
    TextView distance;
    Button arial, actual;
    double lati1 = 28.644800, longi1 = 77.216721, lati2 = 12.972442, longi2 = 77.580643;
    int ar = 0, ac = 0;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latitude1 = findViewById(R.id.latitude1);
        latitude2 = findViewById(R.id.latitude2);
        longitude1 = findViewById(R.id.longitude1);
        longitude2 = findViewById(R.id.longitude2);
        arial = findViewById(R.id.arial);
        actual = findViewById(R.id.actual);
        distance = findViewById(R.id.distance);
        getLocationPermission();

        initAll();
    }
    public void initAll() {
        arial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    lati1 = Double.parseDouble(latitude1.getText().toString());
                    longi1 = Double.parseDouble(longitude1.getText().toString());
                    lati2 = Double.parseDouble(latitude2.getText().toString());
                    longi2 = Double.parseDouble(longitude2.getText().toString());
                    LatLng point1 = new LatLng(lati1, longi1);
                    LatLng point2 = new LatLng(lati2, longi2);
                    mMap.clear();


                    mMap.addMarker(new MarkerOptions().position(point1).title("This is " + lati1 + " , " + longi1));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(point1));
                    mMap.addMarker(new MarkerOptions().position(point2).title("This is " + lati2 + " , " + longi2));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(point2));
                    double distance1 = SphericalUtil.computeDistanceBetween(point1, point2);
                    ar = (int) distance1 / 1000;
                    distance.setText("Arial : " + ar + " KMs  |  " + "Actual : " + ac + " KMs");

                } catch (Exception e) {

                }


            }
        });

        actual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    lati1 = Double.parseDouble(latitude1.getText().toString());
                    longi1 = Double.parseDouble(longitude1.getText().toString());
                    lati2 = Double.parseDouble(latitude2.getText().toString());
                    longi2 = Double.parseDouble(longitude2.getText().toString());
                    LatLng point1 = new LatLng(lati1, longi1);
                    LatLng point2 = new LatLng(lati2, longi2);
                    mMap.clear();


                    mMap.addMarker(new MarkerOptions().position(point1).title("This is " + lati1 + " , " + longi1));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(point1));
                    mMap.addMarker(new MarkerOptions().position(point2).title("This is " + lati2 + " , " + longi2));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(point2));
                    getDistance(lati1,longi1,lati2,longi2);
                    distance.setText("Arial : " + ar + " KMs  |  " + "Actual : " + ac + " KMs");

                } catch (Exception e) {

                }


            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng point1 = new LatLng(lati1, longi1);
        LatLng point2 = new LatLng(lati2, longi2);
        mMap.addMarker(new MarkerOptions().position(point1).title("New Delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point1));
        mMap.addMarker(new MarkerOptions().position(point2).title("Bangalore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point2));
        double distance1 = SphericalUtil.computeDistanceBetween(point1, point2);
        ar = (int) distance1 / 1000;
        getDistance(lati1, longi1,lati2,longi2);
        distance.setText("Arial : " + ar + " KMs  |  " + "Actual : " + ac + " KMs");
    }

    private void getLocationPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                1);
    }

    public void getDistance(final double lat1, final double lon1, final double lat2, final double lon2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   // URL url=new URL("https://maps.googleapis.com/maps/api/directions/json?origin=sydney,au&destination=perth,au&waypoints=via:-37.81223%2C144.96254%7Cvia:-34.92788%2C138.60008&key=AIzaSyCsbv5QqoEoZgaCgQjqbZ-v_vBYsSVXwsY");
                   URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + lat1 + "," + lon1 + "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric&mode=driving&key=AIzaSyCsbv5QqoEoZgaCgQjqbZ-v_vBYsSVXwsY");
                    final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    String response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("routes");
                    JSONObject routes = array.getJSONObject(0);
                    JSONArray legs = routes.getJSONArray("legs");
                    JSONObject steps = legs.getJSONObject(0);
                    JSONObject distance = steps.getJSONObject("distance");
                    ac = Integer.parseInt(distance.getString("text"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
