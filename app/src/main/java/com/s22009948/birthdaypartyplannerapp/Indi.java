package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Indi extends AppCompatActivity {
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
        setContentView(R.layout.activity_indi);

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
                Toast.makeText(Indi.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to update the ImageButton icon based on the vote status
    private void updateVoteIcon() {
        int icon = isVote ? R.drawable.icons8_rstar_50 : R.drawable.icons8_star_50;
        imageButton.setImageResource(icon);
    }
}
