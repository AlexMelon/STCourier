package com.alex.stcourier.domestic.pres.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alex.stcourier.databinding.FragmentDomesticBinding
import com.alex.stcourier.domestic.pres.viewmodel.DomesticViewModel

class DomesticFragment : Fragment() {

    private lateinit var binding: FragmentDomesticBinding
    private val viewModel: DomesticViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDomesticBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Set up the state dropdown (AutoCompleteTextView)
        val states = listOf("Andhra Pradesh", "Karnataka", "Maharashtra", "Tamil Nadu", "Telangana")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, states)
        binding.autoCompleteState.setAdapter(adapter)

        // Make sure the AutoCompleteTextView is clickable and editable for dropdown
        binding.autoCompleteState.isFocusable = true
        binding.autoCompleteState.isFocusableInTouchMode = true

        // Update ViewModel when a state is selected
        binding.autoCompleteState.setOnItemClickListener { parent, _, position, _ ->
            val selectedState = parent.getItemAtPosition(position) as String
            viewModel.selectedState.value = selectedState
        }

        return binding.root
    }
}
