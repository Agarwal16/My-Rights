package com.example.myrights.viewmodel.equality.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myrights.viewmodel.equality.fragment.F14
import com.example.myrights.viewmodel.equality.fragment.F15
import com.example.myrights.viewmodel.equality.fragment.F16
import com.example.myrights.viewmodel.equality.fragment.F17
import com.example.myrights.viewmodel.equality.fragment.F18

@Suppress("DEPRECATION")
internal class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                F14()
            }
            1 -> {
                F15()
            }
            2 -> {
                F16()
            }
            3 ->{
                F17()
            }
            4 -> {
                F18()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}