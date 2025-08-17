package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.s22009948.birthdaypartyplannerapp.databinding.ActivitySignUpPageBinding;

public class SignUpPage extends AppCompatActivity {
     // Declare binding and database helper variables
     ActivitySignUpPageBinding binding;
     DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize binding and set the content view
        binding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Initialize the database helper
        databaseHelper = new DatabaseHelper(this);

        // set an onClickListener for the login button
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from the input fields
                String email = binding.signupEmail.getText().toString();
                String username = binding.signupUser.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmpassword = binding.signupConPassword.getText().toString();

                // Check if any field is empty
                if(email.equals("") || username.equals("") || password.equals("") || confirmpassword.equals(""))
                    Toast.makeText(SignUpPage.this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
                else {
                    // Check if password and confirm password match
                    if (password.equals(confirmpassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if(checkUserEmail == false){
                            // Insert data into the database
                            Boolean insert = databaseHelper.insertData(email,password);
                            // Show a toast message based on the result of the insert operation
                            if (insert == true){
                                Toast.makeText(SignUpPage.this,"Signup Successfully", Toast.LENGTH_SHORT).show();
                                // Navigate to the login page
                                Intent intent = new Intent(getApplicationContext(), LogInPage.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignUpPage.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignUpPage.this,"User already exists, please login", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpPage.this,"Invalid password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}