package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DecorationPage extends AppCompatActivity {

    // Declare buttons for partydecor and partycare decoreters
    private Button btnpartydec;
    private Button btnpartycare;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_decoration_page);

        // Initialize the button for partydeco and set its click listener
        btnpartydec=findViewById(R.id.btnpartydec);
        btnpartydec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start partydeco activity when btnpartydec is clicked
                Intent intent=new Intent(DecorationPage.this, PartyDecor.class);
                startActivity(intent);
            }
        });

        // Initialize the button for partycare and set its click listener
        btnpartycare=findViewById(R.id.btnpartycare);
        btnpartycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start partycare activity when btnpartycare is clicked
                Intent intent=new Intent(DecorationPage.this, PartyCare.class);
                startActivity(intent);
            }
        });
    }
}