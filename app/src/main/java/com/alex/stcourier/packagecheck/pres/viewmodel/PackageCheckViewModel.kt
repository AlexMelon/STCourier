package com.alex.stcourier.packagecheck.pres.viewmodel

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class PackageCheckViewModel(application: Application) : AndroidViewModel(application) {

    val weight = MutableLiveData<String>()
    val length = MutableLiveData<String>()
    val width = MutableLiveData<String>()
    val height = MutableLiveData<String>()

    fun onSubmit() {
        val context = getApplication<Application>()
        if (validateFields()) {
            Toast.makeText(context, "Package Details Submitted!", Toast.LENGTH_LONG).show()
            // Process data or send to backend
        } else {
            Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateFields(): Boolean {
        return !TextUtils.isEmpty(weight.value) &&
                !TextUtils.isEmpty(length.value) &&
                !TextUtils.isEmpty(width.value) &&
                !TextUtils.isEmpty(height.value)
    }

}