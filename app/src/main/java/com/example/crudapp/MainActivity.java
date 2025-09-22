package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // Declaring UI components
    TextView btn_skip;
    Button btn_signin;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enabling Edge-to-Edge mode for modern UI experience
        EdgeToEdge.enable(this);
        // Setting the layout for the activity
        setContentView(R.layout.activity_main);


        // Initializing the 'Skip' button and setting click event
        btn_skip = findViewById(R.id.btnSkip);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Displaying a toast message when the button is clicked
                Toast.makeText(MainActivity.this, "Skip", Toast.LENGTH_SHORT).show();

                // Navigating to HomeActivity
                Intent intent = new Intent(MainActivity.this , HomeActivity.class);
                startActivity(intent);
            }
        });



        // Initializing the 'Sign In' and 'Sign Up' buttons
        btn_signin = findViewById(R.id.btnSignIn);
        btn_signup = findViewById(R.id.btnSignUp);


        // Setting click event for the 'Sign In' button
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Displaying a toast message
                Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();

                // Navigating to SignInActivity
                Intent intent = new Intent(MainActivity.this , SignInActivity.class);
                startActivity(intent);
            }
        });

        // Setting click event for the 'Sign Up' button
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Displaying a toast message
                Toast.makeText(MainActivity.this, "Register", Toast.LENGTH_SHORT).show();

                // Navigating to SignUpActivity
                Intent intent = new Intent(MainActivity.this , SignUpActivity.class);
                startActivity(intent);
            }
        });



        // Handling system bars insets for proper UI display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}