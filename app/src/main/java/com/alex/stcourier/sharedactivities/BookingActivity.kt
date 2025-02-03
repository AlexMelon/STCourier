package com.alex.stcourier.sharedactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alex.stcourier.R
import com.alex.stcourier.databinding.ActivityBookingBinding
import com.alex.stcourier.domestic.pres.fragment.DomesticFragment
import com.alex.stcourier.international.pres.fragment.InternationalFragment
import com.alex.stcourier.utils.ViewPager2Disabler

class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up ViewPager2
        binding.viewPager.adapter = ViewPagerAdapter(this)

        //Disable Swiping
        ViewPager2Disabler(binding.viewPager).disableSwipe()

        // Set initial button state
        updateButtonState(0)

        // Handle button clicks
        binding.btnDomestic.setOnClickListener {
            binding.viewPager.currentItem = 0
            updateButtonState(0)
        }

        binding.btnInternational.setOnClickListener {
            binding.viewPager.currentItem = 1
            updateButtonState(1)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun updateButtonState(selectedIndex: Int) {
        val primaryColor = ContextCompat.getColor(this, R.color.buttonColor)
        val grayColor = ContextCompat.getColor(this, R.color.gray)
        val whiteColor = ContextCompat.getColor(this, R.color.white)

        // Update button colors based on selection
        binding.btnDomestic.apply {
            setBackgroundColor(if (selectedIndex == 0) primaryColor else grayColor)
            setTextColor(whiteColor)
        }

        binding.btnInternational.apply {
            setBackgroundColor(if (selectedIndex == 1) primaryColor else grayColor)
            setTextColor(whiteColor)
        }
    }

    // ViewPager2 Adapter for managing fragments
    class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> DomesticFragment()
                1 -> InternationalFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }
}
