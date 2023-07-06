package com.example.myrights

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val cardView1 = view.findViewById<CardView>(R.id.card_equality)
        val cardView2 = view.findViewById<CardView>(R.id.card_freedom)
        val cardView3 = view.findViewById<CardView>(R.id.card_exploitation)
        val cardView4 = view.findViewById<CardView>(R.id.card_religion)
        val cardView5 = view.findViewById<CardView>(R.id.card_cultural)
        val cardView6 = view.findViewById<CardView>(R.id.card_remedies)

        val imageView1 = view.findViewById<ImageView>(R.id.ic_profile)
        
       
        cardView1.setOnClickListener {
            val intent = Intent(activity, Equality::class.java)
            startActivity(intent)
        }
        cardView2.setOnClickListener {
            val intent = Intent(activity, Freedom::class.java)
            startActivity(intent)
        }
        cardView3.setOnClickListener {
            val intent = Intent(activity, Exploitation::class.java)
            startActivity(intent)
        }
        cardView4.setOnClickListener {
            val intent = Intent(activity, Religion::class.java)
            startActivity(intent)
        }
        cardView5.setOnClickListener {
            val intent = Intent(activity, Cultural::class.java)
            startActivity(intent)
        }
        cardView6.setOnClickListener {
            val intent = Intent(activity, Remedies::class.java)
            startActivity(intent)
        }
        imageView1.setOnClickListener {
            val intent = Intent(activity, Profile::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
