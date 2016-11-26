package com.bititpoikittain.mobiilimatkustaminen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartTripActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);
    }

    public void buyTrip(View view) {
        Intent intent = new Intent(this, TripActiveActivity.class);
        startActivity(intent);
    }
}
