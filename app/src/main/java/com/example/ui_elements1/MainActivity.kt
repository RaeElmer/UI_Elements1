package com.example.ui_elements1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val emailAddress = findViewById<EditText>(R.id.emailAddress)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        val switch1 = findViewById<Switch>(R.id.switch1)
        val progressAge = findViewById<TextView>(R.id.progressAge)
        editTextPhone.visibility = View.GONE

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                progressAge.text = "$i"

            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext, "start tracking", Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext, "stop tracking", Toast.LENGTH_SHORT).show()
            }
        })

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                editTextPhone.visibility = View.VISIBLE //making visible
            }else if (!isChecked){
                editTextPhone.visibility = View.GONE //making invisible
            }
        }

        nextPageButton.setOnClickListener {

            val fName = firstName.text.toString()
            val lName = lastName.text.toString()
            val email = emailAddress.text.toString()
            val phone = editTextPhone.text.toString()
            val progressAge = progressAge.text.toString()

            val intent = Intent(this@MainActivity,NextActivity::class.java);

            intent.putExtra("Username", fName)
            intent.putExtra("UserLastName", lName)
            intent.putExtra("Email", email)
            intent.putExtra("Phone", phone)
            intent.putExtra("Age", progressAge)
            startActivity(intent);
        }

    }
}