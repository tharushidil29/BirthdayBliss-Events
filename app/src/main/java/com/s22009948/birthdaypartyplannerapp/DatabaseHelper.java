package com.s22009948.birthdaypartyplannerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name constant
    public static final String databaseName = "Signup_db";

    // Constructor to initialize the DatabaseHelper
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup_db", null, 1);
    }

    // Method called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        // Create a table called 'allusers' with columns 'email' (primary key) and 'password'
        MyDatabase.execSQL("create Table allusers(email TEXT primary key, password TEXT) ");
    }

    // Method called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        // Drop the existing 'allusers' table if it exists
        MyDatabase.execSQL("drop Table if exists allusers");
    }

    // Method to insert a new user's data into the 'allusers' table
    public Boolean insertData(String email, String password){
        // Get writable access to the database
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        // Create a ContentValues object to store the email and password
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        // Insert the data into the 'allusers' table
        long result = MyDatabase.insert("allusers", null, contentValues);
        // Check if the insertion was successful
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    // Method to check if a given email exists in the 'allusers' table
    public Boolean checkEmail(String email){
        // Get writable access to the database
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        // Query the 'allusers' table to find the given email
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?", new String[]{email});
        // Check if any results were returned
        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    // Method to check if a given email and password combination exists in the 'allusers' table
    public Boolean checkEmailPassword(String email, String password){
        // Get writable access to the database
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        // Query the 'allusers' table to find the given email and password combination
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? and password = ?", new String[]{email,password});
        // Check if any results were returned
        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
