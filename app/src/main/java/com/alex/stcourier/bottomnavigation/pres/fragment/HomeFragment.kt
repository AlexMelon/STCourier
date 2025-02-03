package com.alex.stcourier.bottomnavigation.pres.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.alex.stcourier.R
import com.alex.stcourier.databinding.FragmentHomeBinding
import com.alex.stcourier.sharedactivities.BookingActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding  // Data Binding Variable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout using DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.bookCard.setOnClickListener {
            startActivity(Intent(activity, BookingActivity::class.java))
        }

        return binding.root
    }
}
