package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CakePage extends AppCompatActivity {
    // Declare buttons for cakeshop and cakelk  sellers
    private Button btncakeshop;
    private Button btncakelk;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_cake_page);

        // Initialize the button for cakeshop and set its click listener
        btncakeshop=findViewById(R.id.btncakeshop);
        btncakeshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start cakeshop activity when btncakeshop is clicked
                Intent intent=new Intent(CakePage.this, CakeShop.class);
                startActivity(intent);
            }
        });

        // Initialize the button for cakelk and set its click listener
        btncakelk=findViewById(R.id.btncakelk);
        btncakelk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start cakelk activity when btncakelk is clicked
                Intent intent=new Intent(CakePage.this, CakeLk.class);
                startActivity(intent);
            }
        });
    }
}