package com.alex.stcourier.bottomnavigation.pres.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alex.stcourier.databinding.FragmentTrackBinding
import com.alex.stcourier.bottomnavigation.pres.viewmodel.TrackViewModel

class TrackFragment : Fragment() {

    private lateinit var binding: FragmentTrackBinding
    private val viewModel: TrackViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
