package com.example.jointest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var contryCode: TextView
    private lateinit var phoneNumber: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init
        spinner = findViewById(R.id.contryName)
        contryCode = findViewById(R.id.contryCode)
        phoneNumber = findViewById(R.id.joinPhoneNumber)

        val list3 = arrayOf("Contry","apple", "banana", "orange", "grape", "melon")


        // 2. spinner 어댑터 연결
        spinner.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, list3)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            //click event
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                contryCode.text = list3[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
}