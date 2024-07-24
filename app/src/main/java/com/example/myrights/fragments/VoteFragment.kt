package com.example.myrights.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myrights.R
import com.example.myrights.viewmodel.vote.Vote2
import com.example.myrights.viewmodel.Website


class VoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_vote, container, false)



        val button1 = view.findViewById<Button>(R.id.know_more)
        button1.setOnClickListener {
            val intent = Intent(activity, Vote2::class.java)
            startActivity(intent)
        }

        val button2 = view.findViewById<Button>(R.id.website)
        button2.setOnClickListener {
            val intent = Intent(activity, Website::class.java)
            startActivity(intent)
        }


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = VoteFragment()
    }
}
