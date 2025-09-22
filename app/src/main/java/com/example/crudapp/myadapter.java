package com.example.crudapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;



// Adapter class to handle RecyclerView items using FirebaseRecyclerAdapter
public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{

    // Constructor to initialize FirebaseRecyclerAdapter with options
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    // Method to bind data to each RecyclerView item
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull model model)
    {
        // Setting values from the model class into the ViewHolder components
        holder.name.setText(model.getName());
        holder.course.setText(model.course);
        holder.course.setText(model.getCourse());
        holder.email.setText(model.email);
        holder.number.setText(model.number);

        // Using Glide to load and display the image from the URL
        Glide.with(holder.img.getContext()).load(model.getSurl()).into(holder.img);


        // Handling the edit button click to update data
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1240)  // Expand dialog size
                        .create();


                // Getting references to the input fields in the dialog layout
                View myview = dialogPlus.getHolderView();
                EditText surl = myview.findViewById(R.id.uimgurl);
                EditText name = myview.findViewById(R.id.uname);
                EditText course = myview.findViewById(R.id.ucourse);
                EditText email = myview.findViewById(R.id.uemail);
                EditText number = myview.findViewById(R.id.unumber);
                Button submit = myview.findViewById(R.id.usubmit);


                // Pre-filling input fields with existing data
                surl.setText(model.getSurl());
                name.setText(model.getName());
                course.setText(model.getCourse());
                number.setText(model.getNumber());
                email.setText(model.getEmail());


                // Displaying the dialog
                dialogPlus.show();


                // Handling submit button click to update data in Firebase
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Creating a map to store updated data
                        Map<String,Object> map = new HashMap<>();
                        map.put("surl",surl.getText().toString());
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("course",course.getText().toString());
                        map.put("number",number.getText().toString());

                        // Updating data in Firebase
                        FirebaseDatabase.getInstance().getReference().child("teachers")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        dialogPlus.dismiss();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();

                                    }
                                });

                    }
                });



            }
        });


        // Handling the delete button click to remove data from Firebase
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Confirm Delete");  // Set title of the confirmation dialog
                builder.setMessage("Are you sure you want to permanent delete?");


                // Handling "Yes" button click to delete data from Firebase
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("teachers")
                                .child(getRef(position).getKey()).removeValue();  // Remove item from Firebase

                    }
                });


                // Handling "No" button click to cancel the action
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing, just close the dialog
                    }
                });
                builder.show();  // Show the confirmation dialog
            }
        });

    }


    // Method to inflate the layout for each RecyclerView item
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }


    // Method to update FirebaseRecyclerAdapter options (used for search functionality)
    public void updateOptions(FirebaseRecyclerOptions<model> options) {
        updateOptions(options);
    }


    // ViewHolder class to hold references to the UI components of each RecyclerView item
    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit;
        ImageView delete;
        TextView name,course,email,number;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img1);    // Profile image view
            name = (TextView)itemView.findViewById(R.id.nametext);      // Name text view
            course = (TextView)itemView.findViewById(R.id.coursetext);  // Course text view
            email = (TextView)itemView.findViewById(R.id.emailtext);    // Email text view
            number = (TextView)itemView.findViewById(R.id.numbertext);  // Phone number text view

            edit = (ImageView) itemView.findViewById(R.id.editbtn);      // Edit button
            delete = (ImageView) itemView.findViewById(R.id.deletebtn);  // Delete button
        }
    }

}
