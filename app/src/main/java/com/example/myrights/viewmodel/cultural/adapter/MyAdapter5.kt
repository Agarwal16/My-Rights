package com.example.myrights.viewmodel.cultural.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myrights.viewmodel.cultural.fragment.F29
import com.example.myrights.viewmodel.cultural.fragment.F30

@Suppress("DEPRECATION")
internal class MyAdapter5(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                F29()
            }
            1 -> {
                F30()
            }


            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}