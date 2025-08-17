package com.s22009948.birthdaypartyplannerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
// DatabaseHelper3 class to manage database creation and version management
public class DatabaseHelper3 extends SQLiteOpenHelper {
    // Name of the database
    private static final String DATABASE_NAME = "information.db";
    // Version of the database
    private static final int DATABASE_VERSION = 1;

    // SQL statement to create the BirthdayEntry table
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.BirthdayEntry.TABLE_NAME + " (" +
                    DatabaseContract.BirthdayEntry._ID + " INTEGER PRIMARY KEY," + // Primary key column
                    DatabaseContract.BirthdayEntry.COLUMN_NAME_DISTRICT + " TEXT," + // Column for district
                    DatabaseContract.BirthdayEntry.COLUMN_NAME_DATE + " TEXT," + // Column for date
                    DatabaseContract.BirthdayEntry.COLUMN_NAME_NAME + " TEXT," + // Column for name
                    DatabaseContract.BirthdayEntry.COLUMN_NAME_DESCRIPTION + " TEXT)"; // Column for description

    // SQL statement to delete the BirthdayEntry table if it exists
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.BirthdayEntry.TABLE_NAME;

    // Constructor to initialize the database helper
    public DatabaseHelper3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute the SQL statement to create the table
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    // Called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Execute the SQL statement to delete the table if it exists
        db.execSQL(SQL_DELETE_ENTRIES);
        // Create the table again
        onCreate(db);
    }
}

