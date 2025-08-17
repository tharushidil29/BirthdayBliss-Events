package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShangriLa extends AppCompatActivity {

    // Declare ImageButton variable
    private ImageButton imageButton;
    // Variable to track the vote status
    private boolean isVote;
    // SharedPreferences to store vote status
    private SharedPreferences sharedPreferences;
    // Declare ImageButton variable for call functionality
    ImageButton btncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_shangri_la);

        // Initialize the call button
        btncall = findViewById(R.id.btncall);
        // Set a click listener for the call button
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the dialer with a phone number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0751251697"));
                // Start the activity with the intent
                startActivity(intent);
            }
        });

        // Initialize the button for opening the web page
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the specified web page when the button is clicked
                openWebPage("https://www.shangri-la.com/hambantota/shangrila/");
            }
        });
    }

    // Method to open a web page using an implicit intent
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        // Check if there is an activity available to handle the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        // Initialize the ImageButton
        imageButton = findViewById(R.id.imageButton);
        // Get the SharedPreferences named "Vote"
        sharedPreferences = getSharedPreferences("Vote", Context.MODE_PRIVATE);

        // Retrieve the vote status from SharedPreferences, defaulting to false if not found
        isVote = sharedPreferences.getBoolean("isVote", false);
        // Update the ImageButton icon based on the vote status
        updateVoteIcon();

        // Set a click listener for the ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the vote status
                isVote = !isVote;
                // Save the new vote status to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isVote", isVote);
                editor.apply();
                // Update the ImageButton icon based on the new vote status
                updateVoteIcon();
                // Show a toast message indicating the new vote status
                String message = isVote ? "Thank you for voting!" : "Your vote has been removed.";
                Toast.makeText(ShangriLa.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to update the ImageButton icon based on the vote status
    private void updateVoteIcon() {
        int icon = isVote ? R.drawable.icons8_rstar_50 : R.drawable.icons8_star_50;
        imageButton.setImageResource(icon);
    }
}

