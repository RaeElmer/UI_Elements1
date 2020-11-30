package com.example.ui_elements1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val pickbutton = findViewById<Button>(R.id.pickbutton)
        val completeBtn = findViewById<Button>(R.id.completeBtn)
        val textViewBdate  = findViewById<TextView>(R.id.textViewBdate)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pickbutton.setOnClickListener {

            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    // Display Selected date in TextView
                    textViewBdate.setText("$day/$month/$year")
                },
                year,
                month,
                day
            )
            dpd.show()

        }

        completeBtn.setOnClickListener {

            val date = textViewBdate.text.toString()

            val i = Intent(this@NextActivity, FinalActivity::class.java)
            i.putExtra("Birthday", date)


            i.putExtra("Username",intent.getStringExtra("Username"))
            i.putExtra("UserLastName",intent.getStringExtra("UserLastName"))
            i.putExtra("Email",intent.getStringExtra("Email"))
            i.putExtra("Phone",intent.getStringExtra("Phone"))
            i.putExtra("Age",intent.getStringExtra("Age"))

            startActivity(i)
        }
    }
}