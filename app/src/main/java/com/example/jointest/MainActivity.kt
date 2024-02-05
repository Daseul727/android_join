package com.example.jointest

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.jointest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var spinner: Spinner
    private lateinit var contryCode: TextView
    private lateinit var phoneNumber: EditText

    private lateinit var agreePersonal: Button
    private lateinit var agreeGps: Button
    private lateinit var agreeThird: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        // 3. 이용약관 팝업 이벤트
        agreePersonal = findViewById(R.id.agreePersonal)
        agreeGps = findViewById(R.id.agreeGps)
        agreeThird = findViewById(R.id.agreeThird)

        agreePersonal.setOnClickListener {
            showAlertDialog("개인정보보호약관", R.layout.agree_personal_modal)
        }

        agreeGps.setOnClickListener {
            showAlertDialog("위치기반 서비스약관동의", R.layout.agree_gps_modal)
        }

        agreeThird.setOnClickListener {
            showAlertDialog("제3자 정보제공동의", R.layout.agree_third_modal)
        }
    }
    private fun showAlertDialog(title: String, layoutId: Int) {
        val mDialogView = LayoutInflater.from(this).inflate(layoutId, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(title)

        val mAlertDialog = mBuilder.show()

        val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
        noButton.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

}