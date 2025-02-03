package com.alex.stcourier.login.pres.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alex.stcourier.sharedactivities.MainActivity
import com.alex.stcourier.databinding.ActivityLoginBinding
import com.alex.stcourier.login.pres.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loginSuccess.observe(this, Observer { success ->
            if (success) {
                // Navigate to the next screen (Home, Dashboard, etc.)
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Close login activity
            }
        })
    }
}
