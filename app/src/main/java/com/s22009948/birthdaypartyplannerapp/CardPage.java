package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardPage extends AppCompatActivity {
    // Declare buttons for elegance and sricards  creators
    private Button btnelegance;
    private Button btnsricards;

    // Called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_card_page);

        // Initialize the button for elegance and set its click listener
        btnelegance=findViewById(R.id.btnelegance);
        btnelegance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start elegance activity when btnelegance is clicked
                Intent intent=new Intent(CardPage.this, Elegance.class);
                startActivity(intent);
            }
        });

        // Initialize the button for sricards and set its click listener
        btnsricards=findViewById(R.id.btnsricards);
        btnsricards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start sricards activity when btnsricards is clicked
                Intent intent=new Intent(CardPage.this, SriCards.class);
                startActivity(intent);
            }
        });
    }
}