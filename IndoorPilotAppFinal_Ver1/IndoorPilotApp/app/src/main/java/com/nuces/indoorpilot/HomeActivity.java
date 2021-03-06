package com.nuces.indoorpilot;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nuces.indoorpilot.base.AbstractDrawerActivity;

import java.util.List;
import java.util.Locale;

public class HomeActivity extends AbstractDrawerActivity implements OnMapReadyCallback {
    public GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
        Globals var=Globals.getInstance();
        int numtimes=var.getVarHome();
        if(numtimes==0){
            Intent intent = new Intent(HomeActivity.this,ScanActivity.class);
            startActivity(intent);
        }



    }



    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public String getCustomTitle() {
        return "Home";
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);


        LatLng fast = new LatLng(33.655917, 73.015016);
        LatLng home=new LatLng(33.543202,73.094705);
        LatLng nescom=new LatLng(33.649270,73.017186);
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, zoomLevel));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getApplicationContext(), "Marker clicked: "+marker.getTitle(), Toast.LENGTH_LONG).show();
                if(marker.getTitle().equals("FAST Nuces")){
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("View Map")
                            .setMessage("Do you want to go to indoor map of this building?")
                            .setIcon(R.drawable.icon)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast.makeText(getApplicationContext(), "Loading map... ", Toast.LENGTH_SHORT).show();
                                }})
                            .setNegativeButton(android.R.string.no, null).show();

                }
                else if(marker.getTitle().equals("Nescom")){
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("View Map")
                            .setMessage("Do you want to go to indoor map of this building?")
                            .setIcon(R.drawable.icon)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast.makeText(getApplicationContext(), "Loading map... ", Toast.LENGTH_SHORT).show();
                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }
                else if(marker.getTitle().equals("Home")){
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("View Map")
                            .setMessage("Do you want to go to indoor map of this building?")
                            .setIcon(R.drawable.icon)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                    Toast.makeText(getApplicationContext(), "Loading map... ", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(HomeActivity.this,MapActivity.class);
                                    startActivity(intent);
                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }

                return true;
            }
        });

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                MarkerOptions marker = new MarkerOptions().position(new LatLng(33.655917, 73.015016)).title("FAST Nuces");
                MarkerOptions marker2 = new MarkerOptions().position(new LatLng(33.649270, 73.017186)).title("Nescom");
                MarkerOptions marker3 = new MarkerOptions().position(new LatLng(33.543202, 73.094705)).title("Home");

                marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
                marker2.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
                marker3.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));

                //marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker_icon)));
                mMap.addMarker(marker);
                mMap.addMarker(marker2);
                mMap.addMarker(marker3);
                //mMap.addMarker(new MarkerOptions().position(fast).title("Marker in Fast"));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(fast));


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        if (Build.VERSION.SDK_INT < 23) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            } else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                //mMap.clear();
                LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,16.0f));
            }
        }



    }

}
