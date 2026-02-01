package com.azkaar360;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity 
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int LOCATION_PERMISSION_CODE = 100;
    
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    
    private MaterialCardView morningAzkarCard, eveningAzkarCard, afterPrayerCard;
    private MaterialCardView sleepingAzkarCard, tasbihCard, qiblaCard, prayerTimesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupToolbar();
        setupNavigationDrawer();
        setupCardClickListeners();
        checkLocationPermission();
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        
        morningAzkarCard = findViewById(R.id.morningAzkarCard);
        eveningAzkarCard = findViewById(R.id.eveningAzkarCard);
        afterPrayerCard = findViewById(R.id.afterPrayerCard);
        sleepingAzkarCard = findViewById(R.id.sleepingAzkarCard);
        tasbihCard = findViewById(R.id.tasbihCard);
        qiblaCard = findViewById(R.id.qiblaCard);
        prayerTimesCard = findViewById(R.id.prayerTimesCard);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Azkaar360");
        }
    }

    private void setupNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupCardClickListeners() {
        morningAzkarCard.setOnClickListener(v -> openAzkarDetail("morning"));
        eveningAzkarCard.setOnClickListener(v -> openAzkarDetail("evening"));
        afterPrayerCard.setOnClickListener(v -> openAzkarDetail("afterprayer"));
        sleepingAzkarCard.setOnClickListener(v -> openAzkarDetail("sleeping"));
        
        tasbihCard.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TasbihActivity.class));
        });
        
        qiblaCard.setOnClickListener(v -> {
            if (checkLocationPermission()) {
                startActivity(new Intent(MainActivity.this, QiblaActivity.class));
            }
        });
        
        prayerTimesCard.setOnClickListener(v -> {
            if (checkLocationPermission()) {
                startActivity(new Intent(MainActivity.this, PrayerTimesActivity.class));
            }
        });
    }

    private void openAzkarDetail(String category) {
        Intent intent = new Intent(MainActivity.this, AzkarDetailActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }

    private boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, 
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_CODE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Location permission needed for Prayer Times and Qibla", 
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        
        if (id == R.id.nav_home) {
            // Already on home
        } else if (id == R.id.nav_prayer_times) {
            if (checkLocationPermission()) {
                startActivity(new Intent(this, PrayerTimesActivity.class));
            }
        } else if (id == R.id.nav_tasbih) {
            startActivity(new Intent(this, TasbihActivity.class));
        } else if (id == R.id.nav_qibla) {
            if (checkLocationPermission()) {
                startActivity(new Intent(this, QiblaActivity.class));
            }
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.nav_about) {
            showAboutDialog();
        }
        
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showAboutDialog() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("About Azkaar360")
                .setMessage("Azkaar360 - Your Daily Islamic Companion\n\n" +
                        "Version 1.0\n\n" +
                        "Features:\n" +
                        "• Morning & Evening Azkar\n" +
                        "• Prayer Times\n" +
                        "• Tasbih Counter\n" +
                        "• Qibla Compass\n" +
                        "• Audio Recitations\n\n" +
                        "May Allah accept our efforts.")
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
