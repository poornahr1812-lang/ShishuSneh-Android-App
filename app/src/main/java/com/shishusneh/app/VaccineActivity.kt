package com.shishusneh.app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VaccineActivity : AppCompatActivity() {

    private val vaccineList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val etVaccineName = findViewById<EditText>(R.id.etVaccineName)
        val etVaccineDate = findViewById<EditText>(R.id.etVaccineDate)
        val btnSaveReminder = findViewById<Button>(R.id.btnSaveReminder)
        val listVaccines = findViewById<ListView>(R.id.listVaccines)

        val adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                vaccineList
            )

        listVaccines.adapter = adapter

        btnBack.setOnClickListener {
            finish()
        }

        btnSaveReminder.setOnClickListener {

            val name = etVaccineName.text.toString()
            val date = etVaccineDate.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty()) {
                vaccineList.add("$name - $date")
                adapter.notifyDataSetChanged()

                etVaccineName.text.clear()
                etVaccineDate.text.clear()

                Toast.makeText(
                    this,
                    "Reminder Saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}