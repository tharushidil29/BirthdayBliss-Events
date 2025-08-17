package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.s22009948.birthdaypartyplannerapp.databinding.ActivityLogInPageBinding;

public class LogInPage extends AppCompatActivity {
    // Declare binding and database helper variables
    ActivityLogInPageBinding binding;
    DatabaseHelper databaseHelper;
    private Button btnsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize binding and set the content view
        binding = ActivityLogInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initialize the database helper
        databaseHelper = new DatabaseHelper(this);

        // set an onClickListener for the login button
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from the input fields
               String email = binding.signupEmail.getText().toString();
               String password = binding.signupPassword.getText().toString();
                // Check if any field is empty
               if (email.equals("") || password.equals(""))
                   Toast.makeText(LogInPage.this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
               else {
                   // Check if the provided credentials are correct
                   Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);
                   // Show a toast message based on the result of the credential check
                   if (checkCredentials == true){
                       Toast.makeText(LogInPage.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                       // Navigate to the dashboard page
                       Intent intent = new Intent(getApplicationContext(), DashboardPage.class);
                       startActivity(intent);
                   }else{
                       Toast.makeText(LogInPage.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
        // Initialize the signup button and set an onClickListener
        btnsign=findViewById(R.id.btnSign);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the sign up page
                Intent intent=new Intent(LogInPage.this,SignUpPage.class);
                startActivity(intent);
            }
        });
    }
}