package com.example.myrights

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myrights.adapters.ViewPagerAdapter

class Intro : AppCompatActivity() {
    private lateinit var mSlideViewPager: ViewPager
    private lateinit var skipButton: Button
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        skipButton = findViewById(R.id.skipButton)

        skipButton.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
            finish()
        }

        mSlideViewPager = findViewById(R.id.slideViewPager)
        viewPagerAdapter = ViewPagerAdapter(this)
        mSlideViewPager.adapter = viewPagerAdapter
    }
}
