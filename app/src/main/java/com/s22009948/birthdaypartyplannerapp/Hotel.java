package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hotel extends AppCompatActivity {

    // Declare buttons for shangrila and taj hotels
    private Button btnshangrila;
    private Button btntaj;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_hotel);

        // Initialize the button for shangrila and set its click listener
        btnshangrila=findViewById(R.id.btnshangrila);
        btnshangrila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start shangrila activity when btnshangrila is clicked
                Intent intent=new Intent(Hotel.this, ShangriLa.class);
                startActivity(intent);
            }
        });

        // Initialize the button for taj and set its click listener
        btntaj=findViewById(R.id.btntaj);
        btntaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Taj activity when btntaj is clicked
                Intent intent=new Intent(Hotel.this, Taj.class);
                startActivity(intent);
            }
        });
    }
}