package com.example.myrights.viewmodel.freedom

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.myrights.R
import com.example.myrights.viewmodel.freedom.adapter.MyAdapter2
import com.google.android.material.tabs.TabLayout

class Freedom2 : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freedom2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.nav_color)))
//        val actionBar = supportActionBar
//        actionBar?.title = ""

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("A19"))
        tabLayout.addTab(tabLayout.newTab().setText("A20"))
        tabLayout.addTab(tabLayout.newTab().setText("A21"))
        tabLayout.addTab(tabLayout.newTab().setText("A22"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter2(this, supportFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}