package com.example.myrights.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myrights.R
import com.example.myrights.viewmodel.violation.VoilationRules

class ViolationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_violation, container, false)

        val button = view.findViewById<Button>(R.id.more)
        button.setOnClickListener {
            val intent = Intent(activity, VoilationRules::class.java)
            startActivity(intent)
        }


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ViolationFragment()
    }
}
