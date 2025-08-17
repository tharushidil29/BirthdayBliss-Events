package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LocationPage extends AppCompatActivity {
    // Declare EditText and Button variable
    private EditText editTextStart;
    private EditText editTextEnd;
    private Button btnGetPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_location_page);
        // Initialize EditText and Button by finding views by ID
        editTextStart = findViewById(R.id.editTextStart);
        editTextEnd = findViewById(R.id.editTextEnd);
        btnGetPath = findViewById(R.id.btnGetPath);
        // set an onClickListener for the get path button
        btnGetPath.setOnClickListener(v -> {
            // get text from the input fields
            String startingPoint = editTextStart.getText().toString();
            String endPoint = editTextEnd.getText().toString();
            // Check if any field is empty
            if(startingPoint.equals("")|| endPoint.equals("")){
                Toast.makeText(this,"Please enter starting location & destination",
                        Toast.LENGTH_SHORT).show();
            }else{
                // Get the path using the starting and ending points
                getPath(startingPoint,endPoint);
            }
        });
    }
    // Method to get the path using Google Maps
    private void getPath(String startingPoint, String endPoint) {
        try {
            // Construct the URI for the Google Maps directions
            Uri uri = Uri.parse("https://www.google.com/maps/dir/"+ startingPoint +"/"+ endPoint);
            Intent intent= new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException exception){
            // If the Google Maps app is not found, open the play store to download it
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps&hl=en&ql=US");
            Intent intent= new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

}