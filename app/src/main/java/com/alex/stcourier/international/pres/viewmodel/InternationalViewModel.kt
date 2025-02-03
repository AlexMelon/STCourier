package com.alex.stcourier.international.pres.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InternationalViewModel(application: Application): AndroidViewModel(application) {

    val orginPincode = MutableLiveData<String>()
    val selectedCountry = MutableLiveData<String>()

    private val _navigateToNextScreen = MutableLiveData<Boolean>()
    val navigateToNextScreen: LiveData<Boolean> get() = _navigateToNextScreen

    fun onSubmit() {
        val context = getApplication<Application>()
        if (orginPincode.value.isNullOrEmpty() || selectedCountry.value.isNullOrEmpty()) {
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
        } else {
            _navigateToNextScreen.value = true
            //Toast.makeText(context, "Orgin Pincode: ${orginPincode.value}\nDest Pincode: ${destPincode.value}", Toast.LENGTH_LONG).show()
        }
    }

    fun onNavigationComplete() {
        _navigateToNextScreen.value = false  // Reset event after navigation
    }
}