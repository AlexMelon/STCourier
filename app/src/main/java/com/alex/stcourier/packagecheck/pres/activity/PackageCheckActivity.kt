package com.alex.stcourier.packagecheck.pres.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alex.stcourier.databinding.ActivityPackageCheckBinding
import com.alex.stcourier.packagecheck.pres.viewmodel.PackageCheckViewModel

class PackageCheckActivity : AppCompatActivity() {

    lateinit var binding: ActivityPackageCheckBinding
    private val viewModel: PackageCheckViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPackageCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}