package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInformationPage extends AppCompatActivity {
    // declare EditText and Button variables
    EditText editTextDistrict, editTextDate, editTextName, editTextDescription;
    Button buttonSave, buttonDelete;
    // Database helper object
    DatabaseHelper3 dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_add_information_page);
        // Initialize EditText and Button variables by finding views by ID
        editTextDistrict = findViewById(R.id.editTextDistrict);
        editTextDate = findViewById(R.id.editTextDate);
        editTextName = findViewById(R.id.editTextName);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDelete = findViewById(R.id.buttonDelete);
        // Initialize database helper
        dbHelper = new DatabaseHelper3(this);

        // set onClickListener for the save button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(); // call saveData method when save button is clicked
            }
        });
        // set onClickListener for the delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(); // call deleteData method when delete button is clicked
            }
        });
    }

    // Method to save data to the database
    private void saveData() {
        //Get text from EditText fields
        String district = editTextDistrict.getText().toString();
        String date = editTextDate.getText().toString();
        String name = editTextName.getText().toString();
        String description = editTextDescription.getText().toString();

        //Get writable database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Put data into contentValues
        values.put(DatabaseContract.BirthdayEntry.COLUMN_NAME_DISTRICT, district);
        values.put(DatabaseContract.BirthdayEntry.COLUMN_NAME_DATE, date);
        values.put(DatabaseContract.BirthdayEntry.COLUMN_NAME_NAME, name);
        values.put(DatabaseContract.BirthdayEntry.COLUMN_NAME_DESCRIPTION, description);

        // Insert data into database and get the new row ID
        long newRowId = db.insert(DatabaseContract.BirthdayEntry.TABLE_NAME, null, values);

        // Show a Toast message based on the result of the insert operation
        if (newRowId != -1) {
            Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error saving data.", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to delete data from the database
    private void deleteData() {
        // Get name from EditText field
        String name = editTextName.getText().toString();
        // Get writable database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Delete data from database where the name matches
        int deletedRows = db.delete(DatabaseContract.BirthdayEntry.TABLE_NAME,
                DatabaseContract.BirthdayEntry.COLUMN_NAME_NAME + "=?", new String[]{name});

        // Show a Toast message based on the result of the delete operation
        if (deletedRows > 0) {
            Toast.makeText(this, "Data deleted successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error deleting data.", Toast.LENGTH_SHORT).show();
        }
    }
}
