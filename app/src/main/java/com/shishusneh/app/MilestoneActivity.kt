package com.shishusneh.app

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MilestoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_milestone)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnSaveChecklist = findViewById<Button>(R.id.btnSaveChecklist)

        val cbSmile = findViewById<CheckBox>(R.id.cbSmile)
        val cbHead = findViewById<CheckBox>(R.id.cbHead)
        val cbSound = findViewById<CheckBox>(R.id.cbSound)
        val cbFollow = findViewById<CheckBox>(R.id.cbFollow)

        btnBack.setOnClickListener {
            finish()
        }

        btnSaveChecklist.setOnClickListener {
            Toast.makeText(
                this,
                "Checklist Saved Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}