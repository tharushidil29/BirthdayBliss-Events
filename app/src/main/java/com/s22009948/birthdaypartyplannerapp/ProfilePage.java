package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {
    // Declare EditText, Button, SQLiteOpenHelper, and SQLiteDatabase variables
    private EditText fullNameEditText, addressEditText, contactNumberEditText;
    private Button editButton, saveButton;
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_profile_page);

        // Initialize EditText and Button views by finding them by ID
        fullNameEditText = findViewById(R.id.fullNameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        editButton = findViewById(R.id.editButton);
        saveButton = findViewById(R.id.saveButton);
        // Initialize SQLiteOpenHelper and get writable database
        dbHelper = new DatabaseHelper2(this);
        database = dbHelper.getWritableDatabase();
        // Load profile details from the database
        loadProfile();
        // set an onClickListener for the edit button to enable editing
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableEditing(true);
            }
        });
        // set an onClickListener for the save button to save profile details and disable editing
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
                enableEditing(false);
                Toast.makeText(ProfilePage.this,"Details Saved",Toast.LENGTH_SHORT).show();
            }
        });
    }
    // Method to enable or disable editing of profile details
    private void enableEditing(boolean enable) {
        fullNameEditText.setEnabled(enable);
        addressEditText.setEnabled(enable);
        contactNumberEditText.setEnabled(enable);
        saveButton.setEnabled(enable);
    }
    // Method to load profile details from the database
    private void loadProfile() {
        Cursor cursor = database.query("Profile", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            String fullName = cursor.getString(cursor.getColumnIndex("full_name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String contactNumber = cursor.getString(cursor.getColumnIndex("contact_number"));

            fullNameEditText.setText(fullName);
            addressEditText.setText(address);
            contactNumberEditText.setText(contactNumber);
        }
        cursor.close();
    }
    //Method to save profile details to the database
    private void saveProfile() {
        String fullName = fullNameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String contactNumber = contactNumberEditText.getText().toString();

        ContentValues values = new ContentValues();
        values.put("full_name", fullName);
        values.put("address", address);
        values.put("contact_number", contactNumber);
        //Delete existing profile details and insert new ones
        database.delete("Profile", null, null);
        database.insert("Profile", null, values);
    }
}
