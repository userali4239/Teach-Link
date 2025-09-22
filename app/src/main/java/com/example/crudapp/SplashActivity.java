package com.example.crudapp;  // Package name of the application

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enables edge-to-edge display mode
        EdgeToEdge.enable(this);
        // Sets the layout resource file for the splash screen
        setContentView(R.layout.activity_splash);


        // Creates a delayed action to move from SplashActivity to MainActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            // Intent to navigate from SplashActivity to MainActivity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();   // Finish SplashActivity so the user cannot return to it by pressing back
        }, 1000);  // Delay of 1000 milliseconds (1 second) before starting MainActivity


        // Adjusts padding based on system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}