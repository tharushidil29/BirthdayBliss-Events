package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Declare a button variable
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_main);
        // Initialize buttons by finding by ID
        button=findViewById(R.id.button);
        //set an onClickListener for the button to handle click events
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate to the login page
                Intent intent=new Intent(MainActivity.this,LogInPage.class);
                startActivity(intent);
            }
        });
    }
}