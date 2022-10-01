package com.brian.tellinye.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.brian.tellinye.databinding.FragmentQuotesBinding


class QuotesFragment : Fragment() {

    private val viewModel: YeViewModel by activityViewModels()
//    private var _binding: FragmentQuotesBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentQuotesBinding.inflate(inflater, container, false)

        //call viewmodel method
        viewModel.getYeQuote()
        binding.lifecycleOwner = this
        // Get and Display the loaded quote from SplashFragment
        binding.quoteTextView.text = viewModel.getYeQuote().value?.quote

        binding.quoteButton.setOnClickListener {
            // Get and display more quotes on button click
            binding.quoteTextView.text = viewModel.getYeQuote().value?.quote
        }
        val view = binding.root
        return view
    }
}