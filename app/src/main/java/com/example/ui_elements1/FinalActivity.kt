package com.example.ui_elements1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        var intent = intent
        val fName = intent.getStringExtra("Username")
        val lName = intent.getStringExtra("UserLastName")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val age = intent.getStringExtra("Age")
        val date = intent.getStringExtra("Birthday")

        val resultTV = findViewById<TextView>(R.id.resultTV)

        resultTV.text =
            "First Name: $fName\nLast Name: $lName\nEmail: $email\nPhone: $phone\nAge: $age\nBirthday: $date"

    }
}
