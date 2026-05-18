package com.shishusneh.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GrowthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_growth)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnSaveGrowth = findViewById<Button>(R.id.btnSaveGrowth)
        val btnShareSummary = findViewById<Button>(R.id.btnShareSummary)
        val tvGrowthData = findViewById<TextView>(R.id.tvGrowthData)

        btnBack.setOnClickListener {
            finish()
        }

        btnSaveGrowth.setOnClickListener {

            val weight = etWeight.text.toString()
            val height = etHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {

                tvGrowthData.text =
                    "Weight: $weight kg\nHeight: $height cm"

                Toast.makeText(
                    this,
                    "Growth Saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnShareSummary.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "text/plain"

            intent.putExtra(
                Intent.EXTRA_TEXT,
                tvGrowthData.text.toString()
            )

            startActivity(
                Intent.createChooser(
                    intent,
                    "Share Growth Summary"
                )
            )
        }
    }
}