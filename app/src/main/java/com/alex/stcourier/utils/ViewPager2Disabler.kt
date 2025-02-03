package com.alex.stcourier.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPager2Disabler(private val viewPager2: ViewPager2) {
    fun disableSwipe() {
        viewPager2.getChildAt(0)?.let { recyclerView ->
            (recyclerView as? RecyclerView)?.overScrollMode = View.OVER_SCROLL_NEVER
            recyclerView.setOnTouchListener { _, _ -> true } // Disable touch events
        }
    }
}
