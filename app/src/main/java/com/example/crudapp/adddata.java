package com.example.crudapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


// Activity for adding new data to Firebase
public class adddata extends AppCompatActivity {


    // Declaring UI components
    EditText name,course,email,number,surl;
    Button submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Enables edge-to-edge display for full-screen experience
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adddata);


        // Initializing UI components with their respective IDs
        name = (EditText)findViewById(R.id.add_name);
        course = (EditText)findViewById(R.id.add_course);
        email = (EditText)findViewById(R.id.add_email);
        surl = (EditText)findViewById(R.id.add_surl);
        number = (EditText)findViewById(R.id.add_number);


        // Handling the back button click event
        back = (Button)findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Redirect to HomeActivity and close current activity
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
            }
        });


        // Handling the submit button click event
        submit = (Button)findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();  // Calls the method to insert data into Firebase
            }
        });


        // Handling window insets for better layout management
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    // Method to insert data into Firebase Realtime Database
    private void processinsert()
    {

        // Creating a HashMap to store user input data
        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("course",course.getText().toString());
        map.put("number",number.getText().toString());
        map.put("email",email.getText().toString());
        map.put("surl",surl.getText().toString());


        // Pushing the data to Firebase under the "teachers" node
        FirebaseDatabase.getInstance().getReference().child("teachers").push()
                .setValue(map)  // Adding the data to the database
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        // Clearing input fields after successful insertion
                        name.setText("");
                        course.setText("");
                        number.setText("");
                        email.setText("");
                        surl.setText("");

                        // Showing success message
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {

                        // Showing failure message in case of an error
                        Toast.makeText(getApplicationContext(),"could not Insert",Toast.LENGTH_LONG).show();

                    }
                });


    }
}