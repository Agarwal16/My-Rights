package com.example.myrights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myrights.databinding.ActivityMainBinding
import com.example.myrights.fragments.HomeFragment
import com.example.myrights.fragments.NewsFragment
import com.example.myrights.fragments.ViolationFragment
import com.example.myrights.fragments.VoteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottomBar.setOnItemSelectedListener {menuItem ->

            when (menuItem.itemId) {
                R.id.nav_home -> {
                    inflateFragment(HomeFragment.newInstance())
                }
                R.id.nav_violation -> {
                    inflateFragment(ViolationFragment.newInstance())
                }
                R.id.nav_vote -> {
                    inflateFragment(VoteFragment.newInstance())
                }
                R.id.nav_news -> {
                    inflateFragment(NewsFragment.newInstance())
                }
            }

            true
        }
        bottomBar.selectedItemId = R.id.nav_home
    }

    private fun inflateFragment(newInstance:Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }
}