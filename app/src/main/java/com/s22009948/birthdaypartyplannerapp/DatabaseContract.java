package com.s22009948.birthdaypartyplannerapp;

import android.provider.BaseColumns;
// DatabaseContract class to define the structure of the database
public class DatabaseContract {
    // Private constructor to prevent instantiation
    private DatabaseContract() {}
    // Inner class that defines the table contents
    public static class BirthdayEntry implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "information";
        // Column names
        public static final String COLUMN_NAME_DISTRICT = "district";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
