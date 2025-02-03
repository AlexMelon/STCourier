package com.alex.stcourier.login.pres.viewmodel

import android.app.Application
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginSuccess = MutableLiveData<Boolean>()

    fun onLoginClick() {
        val context = getApplication<Application>()

        if (isValidInput()) {
            // Perform login logic here (e.g., API call, local validation)
            Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
            loginSuccess.value = true
        } else {
            Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            loginSuccess.value = false
        }
    }

    private fun isValidInput(): Boolean {
        return when {
            username.value.isNullOrEmpty() -> false
            password.value.isNullOrEmpty() || password.value!!.length < 6 -> false
            !isValidUsername(username.value!!) -> false
            else -> true
        }
    }

    private fun isValidUsername(input: String): Boolean {
        return Patterns.PHONE.matcher(input).matches() || Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
}
