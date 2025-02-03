package com.alex.stcourier.bottomnavigation.pres.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class TrackViewModel(application: Application) : AndroidViewModel(application) {

    val orderId = MutableLiveData<String>()

    fun onTrackOrderClick() {
        val context = getApplication<Application>()

        if (orderId.value.isNullOrEmpty()) {
            Toast.makeText(context, "Please enter an Order ID", Toast.LENGTH_SHORT).show()
        } else {
            // Perform tracking logic (e.g., API call, database lookup)
            Toast.makeText(context, "Tracking Order: ${orderId.value}", Toast.LENGTH_SHORT).show()
        }
    }
}
