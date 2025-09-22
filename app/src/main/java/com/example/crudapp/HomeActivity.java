package com.example.crudapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    // Declare the RecyclerView, adapter, and FloatingActionButton
    RecyclerView recview;
    myadapter adapter;
    FloatingActionButton fb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


        // // Initialize RecyclerView and set it up with a LinearLayoutManager
        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));


        // Fetch data from Firebase Database using FirebaseRecyclerOptions
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teachers"), model.class)
                        .build();


        // Set up the adapter with the fetched options
        adapter = new myadapter(options);
        recview.setAdapter(adapter);


        // Initialize FloatingActionButton and set an onClickListener for adding data
        fb = (FloatingActionButton) findViewById(R.id.floatadd);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Display a Toast when the FloatingActionButton is clicked
                Toast.makeText(HomeActivity.this, "Add Data", Toast.LENGTH_SHORT).show();
                // Start the AddData activity to add new data
                Intent intent = new Intent(HomeActivity.this , adddata.class);
                startActivity(intent);

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // // Set up the SearchView to listen for text changes and filter data
        // setupSearchView();
    }


    // Override onStart to start listening for changes in Firebase when the activity starts
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();   // Start listening for data changes in Firebase
    }




    // Override onStop to stop listening when the activity stops
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();  // Stop listening to data when the activity is no longer visible
    }
}

// Method to search the Firebase Database based on a query (e.g., teacher's name)
   /* @SuppressLint("NotifyDataSetChanged")
    private void searchInDatabase(String query)
    {

        // Update FirebaseRecyclerOptions to filter data by the query
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teachers")
                                .orderByChild("name").startAt(query).endAt(query + "\uf8ff"), model.class)
                        .build();

        adapter.updateOptions(options); // Update the adapter's options to reflect the search filter
        adapter.notifyDataSetChanged();
    }

    // Method to set up the SearchView and listen for text changes or submission
    private void setupSearchView() {
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // When the user submits a query, perform a search
                searchInDatabase(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // When the user types, update the search with the new text
                searchInDatabase(newText);
                return false;
            }
        });
    }*/



