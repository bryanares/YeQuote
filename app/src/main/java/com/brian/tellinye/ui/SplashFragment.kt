package com.brian.tellinye.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.brian.tellinye.R
import com.brian.tellinye.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private val viewModel : YeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSplashBinding.inflate(inflater, container, false)

        //load quote
        viewModel.getYeQuote()

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_quotesFragment2)
        }
        return binding.root
    }
}