package com.bititpoikittain.mobiilimatkustaminen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.proximi.proximiiolibrary.Proximiio;
import io.proximi.proximiiolibrary.ProximiioBeacon;
import io.proximi.proximiiolibrary.ProximiioFactory;
import io.proximi.proximiiolibrary.ProximiioListener;

import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Proximiio proximiio;
    private ProximiioListener listener;
    
    private final static String TAG = "Mobiilimatkustus";
    private final static String IPHONE_BEACON_ID = "7B44B47B-52A1-5381-90C2-F09B6838C5D4";
    
    private List<ProximiioBeacon> action_beacons = new ArrayList();

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
            
            // List<ProximiioBeacon> active_beacons = new ArrayList();
            // List missing_beacons = new ArrayList();
            
            @Override
            public void foundBeacon(ProximiioBeacon beacon, boolean registered){
                Log.d(TAG, "Nähtiin beacon " + beacon.getUUID());
                
                if (beacon.getUUID().equals(IPHONE_BEACON_ID)) {
                    if (!action_beacons.contains(beacon)) {
                        showNotification(null);
                        action_beacons.add(beacon);
                    }
                }
            }
            
            @Override
            public void lostBeacon(ProximiioBeacon beacon, boolean registered){
                if (beacon.getUUID().equals(IPHONE_BEACON_ID)) {
                    showTripEnded(null);
                    action_beacons.remove(beacon);
                }
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
            Log.d(TAG, "onnistui kirjautumisen tallennus");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // proximiio.removeListener(listener);
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

    public void showNotification(View view) {
        VehicleEnteredNotification.notify(this);
    }

    public void showTripEnded(View view) {
        Intent intent = new Intent(this, TripEndedActivity.class);
        startActivity(intent);
    }
    
}
