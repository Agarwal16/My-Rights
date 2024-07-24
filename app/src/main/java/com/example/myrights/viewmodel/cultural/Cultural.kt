package com.example.myrights.viewmodel.cultural

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class Cultural : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.myrights.R.layout.activity_cultural)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,
            com.example.myrights.R.color.nav_color
        )))

        val button = findViewById<Button>(com.example.myrights.R.id.more_cultural)
        button.setOnClickListener{
            val intent = Intent(this, Cultural2::class.java)
            startActivity(intent)
        }
    }
}