package com.example.searchmyreminders

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context?, cursorFactory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, cursorFactory, DATABASE_VERSION) {

    /**
     * Creates database table
     * @param db reference to the chcsearchapp database
     */
    override fun onCreate(db: SQLiteDatabase) {
        // define create statement for studnet table
        val query = "CREATE TABLE " + TABLE_REMINDER + "(" +
                COLUMN_REMINDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_REMINDER_TITLE + " TEXT, " +
                COLUMN_REMINDER_PRIORITY + " TEXT, " +
                COLUMN_REMINDER_DATE + " TEXT);"

        // execute create statement
        db.execSQL(query)
    }

    /**
     * Creates a new version of the database.
     * @param db reference to chcsearchapp database
     * @param oldVersion old version of the database
     * @param newVersion new version of the database
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // define drop statement for the student table
        val query = "DROP TABLE IF EXISTS " + TABLE_REMINDER

        // execute the drop statement
        db.execSQL(query)

        // call method that creates the table
        onCreate(db)
    }

    /**
     * This method gets called by the MainActivity when the app launches.
     * It inserts a new row in the student table.
     * @param name student name
     * @param major student major
     * @param year student year
     */
    fun addReminder(name: String?, major: String?, year: String?) {

        // get reference to chcsearchapp database
        val db = writableDatabase

        // initialize a ContentValues object
        val values = ContentValues()

        // put data into the ContentValues object
        values.put(COLUMN_REMINDER_TITLE, title)
        values.put(COLUMN_REMINDER_PRIORITY, priority)
        values.put(COLUMN_REMINDER_DATE, date)

        // insert data in ContentValues object into student table
        db.insert(TABLE_REMINDER, null, values)

        // close database connection
        db.close()
    }



    companion object {
        // initialize constants for the DB name and version
        private const val DATABASE_NAME = "searchremindersapp.db"
        private const val DATABASE_VERSION = 1

        // initialize constants for the student table
        private const val TABLE_STUDENT = "reminder"
        private const val COLUMN_STUDENT_ID = "_id"
        private const val COLUMN_STUDENT_NAME = "title"
        private const val COLUMN_STUDENT_MAJOR = "priority"
        private const val COLUMN_STUDENT_YEAR = "date"
    }