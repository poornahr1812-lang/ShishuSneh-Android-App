package com.shishusneh.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var etBabyName: EditText
    private lateinit var etDob: EditText
    private lateinit var tvBabyAge: TextView
    private lateinit var etGender: EditText
    private lateinit var etBirthWeight: EditText
    private lateinit var etMotherContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBabyName = findViewById(R.id.etBabyName)
        etDob = findViewById(R.id.etDob)
        tvBabyAge = findViewById(R.id.tvBabyAge)
        etGender = findViewById(R.id.etGender)
        etBirthWeight = findViewById(R.id.etBirthWeight)
        etMotherContact = findViewById(R.id.etMotherContact)

        loadProfile()

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            moveTaskToBack(true)
        }

        findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            saveProfile()
        }

        findViewById<Button>(R.id.btnGrowth).setOnClickListener {
            startActivity(Intent(this, GrowthActivity::class.java))
        }

        findViewById<Button>(R.id.btnVaccine).setOnClickListener {
            startActivity(Intent(this, VaccineActivity::class.java))
        }

        findViewById<Button>(R.id.btnFeeding).setOnClickListener {
            startActivity(Intent(this, FeedingActivity::class.java))
        }

        findViewById<Button>(R.id.btnMilestone).setOnClickListener {
            startActivity(Intent(this, MilestoneActivity::class.java))
        }
    }

    private fun saveProfile() {
        val prefs = getSharedPreferences("BabyProfile", MODE_PRIVATE)

        prefs.edit()
            .putString("name", etBabyName.text.toString())
            .putString("dob", etDob.text.toString())
            .putString("gender", etGender.text.toString())
            .putString("birthWeight", etBirthWeight.text.toString())
            .putString("motherContact", etMotherContact.text.toString())
            .apply()

        tvBabyAge.text = "Baby Age: ${calculateAgeWeeks(etDob.text.toString())} weeks"
        Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfile() {
        val prefs = getSharedPreferences("BabyProfile", MODE_PRIVATE)

        etBabyName.setText(prefs.getString("name", ""))
        etDob.setText(prefs.getString("dob", ""))
        etGender.setText(prefs.getString("gender", ""))
        etBirthWeight.setText(prefs.getString("birthWeight", ""))
        etMotherContact.setText(prefs.getString("motherContact", ""))

        val dob = prefs.getString("dob", "") ?: ""
        tvBabyAge.text = if (dob.isNotEmpty()) {
            "Baby Age: ${calculateAgeWeeks(dob)} weeks"
        } else {
            "Baby Age:"
        }
    }

    private fun calculateAgeWeeks(dob: String): Long {
        return try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val birthDate = sdf.parse(dob)
            val today = System.currentTimeMillis()
            val diff = today - (birthDate?.time ?: today)
            TimeUnit.MILLISECONDS.toDays(diff) / 7
        } catch (e: Exception) {
            0
        }
    }
}