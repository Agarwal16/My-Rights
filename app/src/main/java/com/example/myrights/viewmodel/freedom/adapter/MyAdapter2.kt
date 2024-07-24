package com.example.myrights.viewmodel.freedom.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myrights.viewmodel.freedom.fragment.F19
import com.example.myrights.viewmodel.freedom.fragment.F20
import com.example.myrights.viewmodel.freedom.fragment.F21
import com.example.myrights.viewmodel.freedom.fragment.F22

@Suppress("DEPRECATION")
internal class MyAdapter2(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                F19()
            }
            1 -> {
                F20()
            }
            2 -> {
                F21()
            }
            3 ->{
                F22()
            }

            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}