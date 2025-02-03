package com.alex.stcourier.bottomnavigation.pres.viewmodel

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.alex.stcourier.sharedactivities.MainActivity

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    val username = MutableLiveData<String>("Alex J") // Replace with actual username

    fun onLogoutClick() {
        val context = getApplication<Application>()
        Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()

        // Redirect to Login Screen
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}
