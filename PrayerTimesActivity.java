package com.azkaar360;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PrayerTimesActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private TextView fajrTime, sunriseTime, dhuhrTime, asrTime, maghribTime, ishaTime;
    private TextView locationText, dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Prayer Times");

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        
        initializeViews();
        updateDate();
        getLocationAndCalculatePrayerTimes();
    }

    private void initializeViews() {
        locationText = findViewById(R.id.locationText);
        dateText = findViewById(R.id.dateText);
        fajrTime = findViewById(R.id.fajrTime);
        sunriseTime = findViewById(R.id.sunriseTime);
        dhuhrTime = findViewById(R.id.dhuhrTime);
        asrTime = findViewById(R.id.asrTime);
        maghribTime = findViewById(R.id.maghribTime);
        ishaTime = findViewById(R.id.ishaTime);
    }

    private void updateDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH);
        dateText.setText(dateFormat.format(calendar.getTime()));
    }

    private void getLocationAndCalculatePrayerTimes() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Location permission required", Toast.LENGTH_SHORT).show();
            return;
        }

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        calculatePrayerTimes(location.getLatitude(), location.getLongitude());
                        locationText.setText(String.format(Locale.ENGLISH, 
                            "%.2f°, %.2f°", location.getLatitude(), location.getLongitude()));
                    } else {
                        // Use default location (Mecca)
                        calculatePrayerTimes(21.4225, 39.8262);
                        locationText.setText("Mecca, Saudi Arabia (Default)");
                    }
                });
    }

    private void calculatePrayerTimes(double latitude, double longitude) {
        // Simplified prayer time calculation
        // In production, use a proper library like Adhan
        
        fajrTime.setText("5:30 AM");
        sunriseTime.setText("6:45 AM");
        dhuhrTime.setText("12:30 PM");
        asrTime.setText("3:45 PM");
        maghribTime.setText("6:15 PM");
        ishaTime.setText("7:30 PM");
        
        Toast.makeText(this, 
            "Note: Add Adhan library for accurate prayer times based on location", 
            Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
