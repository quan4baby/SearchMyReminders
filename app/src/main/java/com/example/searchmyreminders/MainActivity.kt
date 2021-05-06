package com.example.searchmyreminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // declare DBHandler as mutable field using null safety
    var dbHandler: DBHandler? = null


    // declare RecyclerView as mutable field using null safety
    var searchRecyclerView: RecyclerView? = null

    // declare a StudentAdapter as a mutable field
    // specify that it will be initialized later
    lateinit var reminderAdapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fully initialize dbHandler
        dbHandler = DBHandler(this, null)

        // make RecyclerView refer to actual RecyclerView in activity_main layout resource
        searchRecyclerView = findViewById<View>(R.id.searchRecyclerView) as RecyclerView

        // initialize a MutableList of Students
        var reminders: MutableList<Reminder> = ArrayList()

        // initialize the StudentAdapter
        reminderAdapter = ReminderAdapter(reminders)

        // tell Kotlin that RecyclerView isn't null and set the StudentAdapter on it
        searchRecyclerView!!.adapter = reminderAdapter

        // tell Kotlin that the RecylerView isn't null and apply a LinearLayout to it
        searchRecyclerView!!.layoutManager = LinearLayoutManager(this)

        // populate the student table in the database
        // these lines of code should be commented out after the
        // app is run the first time
        addReminder("High Priority Reminder 1", "High", "2021-05-02")
        addReminder("High Priority Reminder 2", "High", "2021-05-03")
        addReminder("Medium Priority Reminder 1", "Medium", "2021-05-04")
        addReminder("Medium Priority Reminder 2", "Medium", "2021-05-05")
        addReminder("Low Priority Reminder 1", "Low", "2021-05-06")
        addReminder("Low Priority Reminder 2", "Low", "2021-05-07")
    }

    /**
     * This method populates a student in the database.  It gets called when
     * the app launches.
     * @param name student name
     * @param major student major
     * @param year student year
     */
    fun addReminder(title: String, priority: String, date: String) {
        dbHandler?.addReminder(title, priority, date)
    }

    /**
     * This method gets called when the Search button is clicked.  It
     * searches for students based on the specified search criteria and
     * refreshes the StudentAdapter with the retrieved data so that it
     * may be displayed in the RecyclerView.
     * @param view MainActivity
     */
    fun search(view: View?) {

    }
}