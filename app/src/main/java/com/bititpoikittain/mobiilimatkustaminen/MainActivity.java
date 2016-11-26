package com.bititpoikittain.mobiilimatkustaminen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;

import io.proximi.proximiiolibrary.Proximiio;
import io.proximi.proximiiolibrary.ProximiioFactory;
import io.proximi.proximiiolibrary.ProximiioFloor;
import io.proximi.proximiiolibrary.ProximiioGeofence;
import io.proximi.proximiiolibrary.ProximiioImageCallback;
import io.proximi.proximiiolibrary.ProximiioListener;

import java.sql.Timestamp;


public class MainActivity extends AppCompatActivity {

    private Proximiio proximiio;
    private ProximiioListener listener;

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
            
            @Override
            public void position(double lat, double lon, double accuracy) {
                setPosition(lat, lon, accuracy);
            }
            
            @Override
            public void foundBeacon(ProximiioBeacon beacon, boolean registered){
                //store found beacon's ID and finding time. Send info to server.
                //if no active trip, notify user to start "trip".
                //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            }
            
            @Override
            public void lostBeacon(ProximiioBeacon beacon, boolean registered){
                //Store lost beacon's ID and losing time, try to refind the beacon. after a while send info to server.
                //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            }
        };
        proximiio.addListener(listener);
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
