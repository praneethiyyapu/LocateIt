package com.example.prane.mymaps;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

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

        // Add a marker in UMKC and move the camera
        LatLng umkc = new LatLng(39.0335,-94.5756);
        mMap.addMarker(new MarkerOptions().position(umkc).icon(BitmapDescriptorFactory.
                defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Marker in UMKC"));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(10);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(umkc));
        mMap.animateCamera(zoom);
    }


    public void onLocate(View newView ) throws Exception{
        EditText textFieldLocation = (EditText)findViewById(R.id.editTextLocation);
        String location = textFieldLocation.getText().toString();
        String newLocation = location.trim();
        if (newLocation.equals("")){
            Toast.makeText(MapsActivity.this, "Please input desired location",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Geocoder geocoder = new Geocoder(this);
            List<Address> addresses = geocoder.getFromLocationName(location, 1);
            Address address = addresses.get(0);
            LatLng loc = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc).icon(BitmapDescriptorFactory.
                    defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Marker in "+location));
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(4);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
            mMap.animateCamera(zoom);

        }
    }

}
