package com.example.myrights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        val button: Button = findViewById(R.id.upload)
        button.setOnClickListener {
            val intent = Intent(this@MainScreenActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.feed)
        button2.setOnClickListener {
            val intent = Intent(this@MainScreenActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}