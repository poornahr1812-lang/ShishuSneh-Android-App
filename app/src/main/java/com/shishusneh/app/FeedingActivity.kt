package com.shishusneh.app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FeedingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_feeding)

        // Back Button
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }
    }
}