package com.alex.stcourier.domestic.pres.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class DomesticViewModel(application: Application) : AndroidViewModel(application) {

    val pincode = MutableLiveData<String>()
    val selectedState = MutableLiveData<String>()

    fun onSubmit() {
        val context = getApplication<Application>()
        if (pincode.value.isNullOrEmpty() || selectedState.value.isNullOrEmpty()) {
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Pincode: ${pincode.value}\nState: ${selectedState.value}", Toast.LENGTH_LONG).show()
        }
    }
}
