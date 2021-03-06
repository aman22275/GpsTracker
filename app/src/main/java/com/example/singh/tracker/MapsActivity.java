package com.example.singh.tracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Double lat, lang;


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
        String method = "map";

        TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getDeviceId();

       /* BackGroundTask g= new BackGroundTask(this);
  g.map=mMap;
        g.application = (track)this.getApplication();
        g.execute(method, mPhoneNumber);
*/

        track a = (track) getApplication();
        Double aaaa = a.lat1;
        Double bb = a.lang1;
        LatLng aaa = new LatLng(a.lat, a.lang);
        mMap.addMarker(new MarkerOptions().position(aaa).title("lat + lang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aaa));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(aaa, 15));


        LatLng aa = new LatLng(a.lat1, a.lang1);
        mMap.addMarker(new MarkerOptions().position(aa).title("lat1 + lang1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aa));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(aaa, 15));



    }

}









