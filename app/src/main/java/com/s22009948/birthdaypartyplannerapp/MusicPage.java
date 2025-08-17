package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPage extends AppCompatActivity {
    // Declare buttons for djash and qpoint  Artists
    private Button btndjash;
    private Button btnqpoint;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_music_page);

        // Initialize the button for djash and set its click listener
        btndjash=findViewById(R.id.btndjash);
        btndjash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start djash activity when btndjash is clicked
                Intent intent=new Intent(MusicPage.this, DjAsh.class);
                startActivity(intent);
            }
        });

        // Initialize the button for djqpoint and set its click listener
        btnqpoint=findViewById(R.id.btnqpoint);
        btnqpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start qpoint activity when btnqpoint is clicked
                Intent intent=new Intent(MusicPage.this, qpoint.class);
                startActivity(intent);
            }
        });
    }
}
