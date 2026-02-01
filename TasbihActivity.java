package com.azkaar360;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class TasbihActivity extends AppCompatActivity {

    private TextView counterText, goalText;
    private ProgressBar goalProgress;
    private MaterialButton subhanallahButton, alhamdulillahButton, allahuakbarButton;
    private MaterialButton resetButton, vibrateToggle;
    
    private int count = 0;
    private int goal = 33;
    private boolean vibrateEnabled = true;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        counterText = findViewById(R.id.counterText);
        goalText = findViewById(R.id.goalText);
        goalProgress = findViewById(R.id.goalProgress);
        
        subhanallahButton = findViewById(R.id.subhanallahButton);
        alhamdulillahButton = findViewById(R.id.alhamdulillahButton);
        allahuakbarButton = findViewById(R.id.allahuakbarButton);
        resetButton = findViewById(R.id.resetButton);
        vibrateToggle = findViewById(R.id.vibrateToggle);
        
        updateDisplay();
    }

    private void setupClickListeners() {
        View.OnClickListener countListener = v -> incrementCounter();
        
        subhanallahButton.setOnClickListener(countListener);
        alhamdulillahButton.setOnClickListener(countListener);
        allahuakbarButton.setOnClickListener(countListener);
        
        // Counter circle click
        findViewById(R.id.counterText).getParent().setOnClickListener(v -> incrementCounter());
        
        resetButton.setOnClickListener(v -> resetCounter());
        
        vibrateToggle.setOnClickListener(v -> toggleVibrate());
    }

    private void incrementCounter() {
        count++;
        updateDisplay();
        
        if (vibrateEnabled && vibrator != null) {
            vibrator.vibrate(50);
        }
        
        // Check if goal reached
        if (count == goal) {
            if (vibrator != null) {
                vibrator.vibrate(new long[]{0, 100, 100, 100}, -1);
            }
        }
    }

    private void resetCounter() {
        count = 0;
        updateDisplay();
        
        if (vibrateEnabled && vibrator != null) {
            vibrator.vibrate(100);
        }
    }

    private void toggleVibrate() {
        vibrateEnabled = !vibrateEnabled;
        vibrateToggle.setText(vibrateEnabled ? "Vibrate: ON" : "Vibrate: OFF");
        
        if (vibrateEnabled && vibrator != null) {
            vibrator.vibrate(50);
        }
    }

    private void updateDisplay() {
        counterText.setText(String.valueOf(count));
        goalText.setText(count + " / " + goal);
        goalProgress.setProgress(count);
        
        // Change color when goal reached
        if (count >= goal) {
            goalProgress.setProgressTintList(
                android.content.res.ColorStateList.valueOf(
                    getResources().getColor(android.R.color.holo_green_dark)
                )
            );
        } else {
            goalProgress.setProgressTintList(
                android.content.res.ColorStateList.valueOf(
                    getResources().getColor(R.color.primary_green)
                )
            );
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
