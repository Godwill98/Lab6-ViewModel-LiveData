package com.example.linearandconstrainlayouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textFirstNameInput = findViewById<TextView>(R.id.editTextText2)
        val textSecondNameInput = findViewById<TextView>(R.id.editTextText3)
        val TextViewOutput = findViewById<TextView>(R.id.textView8)
        val ClickButton = findViewById<Button>(R.id.button9)
        val ApartmentNo = findViewById<TextView>(R.id.ApartmentNumber)

        ClickButton.setOnClickListener {
            val FirstName = textFirstNameInput.text.toString()
            val SecondName = textSecondNameInput.text.toString()
            val aprtno = ApartmentNo.text.toString()
            TextViewOutput.text = "Name: $FirstName | SecondName: $SecondName | ApartmentNumber: $aprtno"
        }


    }
}