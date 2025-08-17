package com.s22009948.birthdaypartyplannerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
// DatabaseHelper2 class to manage database creation and version management
public class DatabaseHelper2 extends SQLiteOpenHelper {
    // Name of the database
    private static final String DATABASE_NAME = "user_profile.db";
    // Version of the database
    private static final int DATABASE_VERSION = 1;

    // Constructor to initialize the database helper
    public DatabaseHelper2 (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create the Profile table
        db.execSQL("CREATE TABLE Profile (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," + // Primary key column
                "full_name TEXT," + // Column for full name
                "address TEXT," + // Column for address
                "contact_number TEXT)"); // Column for contact number
    }

    // Called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the existing Profile table if it exists
        db.execSQL("DROP TABLE IF EXISTS Profile");
        // Create the table again
        onCreate(db);
    }
}