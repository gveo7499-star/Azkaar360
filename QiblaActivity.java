package com.azkaar360;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class QiblaActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, magnetometer;
    private FusedLocationProviderClient fusedLocationClient;
    
    private ImageView compassImage;
    private TextView angleText, directionText;
    
    private float[] gravity;
    private float[] geomagnetic;
    private float azimuth = 0f;
    private float qiblaAngle = 0f;
    
    private static final float MECCA_LAT = 21.4225f;
    private static final float MECCA_LNG = 39.8262f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qibla);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Qibla Compass");

        compassImage = findViewById(R.id.compassImage);
        angleText = findViewById(R.id.angleText);
        directionText = findViewById(R.id.directionText);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        
        getLocationAndCalculateQibla();
    }

    private void getLocationAndCalculateQibla() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Location permission required", Toast.LENGTH_SHORT).show();
            return;
        }

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        qiblaAngle = calculateQiblaDirection(
                            location.getLatitude(), 
                            location.getLongitude()
                        );
                    }
                });
    }

    private float calculateQiblaDirection(double latitude, double longitude) {
        // Calculate bearing to Mecca using simplified formula
        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(MECCA_LAT);
        double dLng = Math.toRadians(MECCA_LNG - longitude);

        double y = Math.sin(dLng) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2) - 
                   Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLng);

        double bearing = Math.toDegrees(Math.atan2(y, x));
        return (float) ((bearing + 360) % 360);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            gravity = event.values.clone();
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            geomagnetic = event.values.clone();
        }

        if (gravity != null && geomagnetic != null) {
            float[] R = new float[9];
            float[] I = new float[9];

            boolean success = SensorManager.getRotationMatrix(R, I, gravity, geomagnetic);
            if (success) {
                float[] orientation = new float[3];
                SensorManager.getOrientation(R, orientation);
                azimuth = (float) Math.toDegrees(orientation[0]);
                azimuth = (azimuth + 360) % 360;

                updateCompass();
            }
        }
    }

    private void updateCompass() {
        float rotation = azimuth - qiblaAngle;
        
        compassImage.setRotation(-rotation);
        angleText.setText(String.format("%.0f°", qiblaAngle));
        
        // Determine if pointing toward Qibla
        float difference = Math.abs(rotation % 360);
        if (difference > 180) {
            difference = 360 - difference;
        }
        
        if (difference < 5) {
            directionText.setText("✓ Facing Qibla");
            directionText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            directionText.setText("Turn to align with arrow");
            directionText.setTextColor(getResources().getColor(R.color.text_secondary_light));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for this implementation
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
