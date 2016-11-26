package com.bititpoikittain.mobiilimatkustaminen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;

import io.proximi.proximiiolibrary.Proximiio;
import io.proximi.proximiiolibrary.ProximiioBeacon;
import io.proximi.proximiiolibrary.ProximiioFactory;
import io.proximi.proximiiolibrary.ProximiioFloor;
import io.proximi.proximiiolibrary.ProximiioGeofence;
import io.proximi.proximiiolibrary.ProximiioImageCallback;
import io.proximi.proximiiolibrary.ProximiioListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Proximiio proximiio;
    private ProximiioListener listener;
    
    private final static String TAG = "Mobiilimatkustus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
    }

    @Override
    protected void onStart() {
        super.onStart();

        proximiio = ProximiioFactory.getProximiio(this, this);

    
        listener = new ProximiioListener() {
            
            // List active_beacons = new ArrayList();
            // List missing_beacons = new ArrayList();

            @Override
            public void position(double lat, double lon, double accuracy) {
                // setPosition(lat, lon, accuracy);
            }
            
            @Override
            public void foundBeacon(ProximiioBeacon beacon, boolean registered){
                Log.d(TAG, "Nähtiin beacon ");
                // //store found beacon's ID and finding time. Send info to server if new.
                // //if no active trip, notify user to start "trip".
                // Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                // boolean contains = false;
                // if (!active_beacons.isEmpty()){
                //     for (int i=0;i<active_beacons.size();i++){
                //         if (active_beacons.get(i).contains(beacon)){
                //             contains=true;
                //         }
                //     }
                // }
                // if (!contains){
                //     List found_beacon = new ArrayList(beacon,timestamp);
                //     active_beacons.add(found_beacon);
                // }
                // //check if found beacon was missing
                // if (!missing_beacons.isEmpty()){
                //     for (int i=0;i<missing_beacons.size();i++){
                //         if (missing_beacons.get(i).contains(beacon)){
                //             missing_beacons.remove(i);
                //         }
                //     }
                // }
            }
            
            @Override
            public void lostBeacon(ProximiioBeacon beacon, boolean registered){
                // //Store lost beacon's ID and losing time, try to refind the beacon. after a while send info to server.
                // Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                // List lost_beacon = new ArrayList(beacon, timestamp);
                // missing_beacons.add(lost_beacon);
            }
            //add function which: sends server info about lost beacon and remove that info from active/missing beacons lists
            
            @Override
            public void loginFailed(LoginError loginError) {
                Log.e(TAG, "LoginError! (" + loginError.toString() + ")");
            }
            
            @Override
            public void loggedIn(boolean online) {
                Log.d(TAG, "Kirjautuminen jees");
            }
            
        };
        proximiio.addListener(listener);
        

        proximiio.setAuth("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImlzcyI6ImU5NzVkZmE1M2FmMDRlOGFhZGM1MzNjZDVjMWVkYTBkIiwidHlwZSI6ImFwcGxpY2F0aW9uIiwiYXBwbGljYXRpb25faWQiOiI4NWYzYjRmMi1mMjRhLTRiNmUtYjRiMy04MThjNzQyZjNhOTEifQ.Dt6bQHTIZEGUU9kCuc8sUP0CI3AJWOTReoeSW_B1dgs");
        if (proximiio.trySavedLogin()) {
            Log.d(TAG, "onnistui");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        proximiio.removeListener(listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        proximiio.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        proximiio.onActivityResult(requestCode, resultCode, data);
    }
    
}
