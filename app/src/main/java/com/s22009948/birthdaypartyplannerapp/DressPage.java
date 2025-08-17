package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DressPage extends AppCompatActivity {

    // Declare buttons for house of indi and the design collective designers
    private Button btnindi;
    private Button btndesign;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_dress_page);

        // Initialize the button for indi and set its click listener
        btnindi=findViewById(R.id.btnindi);
        btnindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start elegance activity when btnindi is clicked
                Intent intent=new Intent(DressPage.this, Indi.class);
                startActivity(intent);
            }
        });

        // Initialize the button for design and set its click listener
        btndesign=findViewById(R.id.btndesign);
        btndesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start elegance activity when btndesign is clicked
                Intent intent=new Intent(DressPage.this, DesignCollective.class);
                startActivity(intent);
            }
        });
    }
}