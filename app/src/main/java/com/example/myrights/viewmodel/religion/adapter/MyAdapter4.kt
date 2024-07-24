package com.example.myrights.viewmodel.religion.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myrights.viewmodel.religion.fragment.F25
import com.example.myrights.viewmodel.religion.fragment.F26
import com.example.myrights.viewmodel.religion.fragment.F27
import com.example.myrights.viewmodel.religion.fragment.F28

@Suppress("DEPRECATION")
internal class MyAdapter4(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                F25()
            }
            1 -> {
                F26()
            }
            2 -> {
                F27()
            }
            3 -> {
                F28()
            }


            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}