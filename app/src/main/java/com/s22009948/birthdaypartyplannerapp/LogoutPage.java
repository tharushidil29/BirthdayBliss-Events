package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogoutPage extends AppCompatActivity {
    //Declare Button variables
    private Button btnyes;
    private Button btnno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_logout_page);
        // Initialize button by finding by ID
        btnyes=findViewById(R.id.btnyes);
        //set onClickListener for yes button to navigate to MainActivity
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the MainActivity page
                Intent intent=new Intent(LogoutPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Initialize button by finding by ID
        btnno=findViewById(R.id.btnno);
        //set onClickListener for no button to navigate to DashboardPage activity
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Dashboard page
                Intent intent=new Intent(LogoutPage.this, DashboardPage.class);
                startActivity(intent);
            }
        });
    }
}