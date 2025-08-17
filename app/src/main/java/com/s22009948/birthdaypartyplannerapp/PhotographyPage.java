package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PhotographyPage extends AppCompatActivity {

    // Declare buttons for Nick and Sri photographers
    private Button btnnick;
    private Button btnsri;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_photography_page);

        // Initialize the button for Nick and set its click listener
        btnnick=findViewById(R.id.btnnick);
        btnnick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NickJones activity when btnnick is clicked
                Intent intent=new Intent(PhotographyPage.this, NickJones.class);
                startActivity(intent);
            }
        });

        // Initialize the button for Sri and set its click listener
        btnsri=findViewById(R.id.btnsri);
        btnsri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SriDevi activity when btnsri is clicked
                Intent intent=new Intent(PhotographyPage.this, SriDevi.class);
                startActivity(intent);
            }
        });
    }
}