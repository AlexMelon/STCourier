package com.alex.stcourier.international.pres.fragment

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alex.stcourier.packagecheck.pres.activity.PackageCheckActivity
import com.alex.stcourier.databinding.FragmentInternationalBinding
import com.alex.stcourier.international.pres.viewmodel.InternationalViewModel

class InternationalFragment : Fragment() {

    private var _binding: FragmentInternationalBinding? = null
    private val binding get() = _binding!!  // Safe access to binding
    private val viewModel: InternationalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInternationalBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val states = listOf("USA-United State of America", "United Kingdom", "Russia", "China", "Ireland")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_dropdown_item_1line, states)
        binding.autoCompleteCountry.setAdapter(adapter)

        // Make sure the AutoCompleteTextView is clickable and editable for dropdown
        binding.autoCompleteCountry.isFocusable = true
        binding.autoCompleteCountry.isFocusableInTouchMode = true

        // Update ViewModel when a state is selected
        binding.autoCompleteCountry.setOnItemClickListener { parent, _, position, _ ->
            val selectedState = parent.getItemAtPosition(position) as String
            viewModel.selectedCountry.value = selectedState
        }

        // Observe navigation event
        viewModel.navigateToNextScreen.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                val intent = Intent(requireContext(), PackageCheckActivity::class.java)
                startActivity(intent)
                viewModel.onNavigationComplete()  // Reset navigation event
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // Prevent memory leaks
    }
}
