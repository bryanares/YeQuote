package com.brian.tellinye.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.brian.tellinye.databinding.FragmentQuotesBinding


class QuotesFragment : Fragment() {

    private val viewModel: YeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentQuotesBinding.inflate(inflater, container, false)
        //call viewModel method

        viewModel.setRepo(requireActivity().application)
        viewModel.getQuote()
        binding.lifecycleOwner = this

        // Get and Display the loaded quote from SplashFragment
        binding.quoteButton.setOnClickListener {
            viewModel.getQuote()
        }

        viewModel.yeQuotes.observe(this.viewLifecycleOwner) {
            binding.quoteTextView?.text = it.quote
        }

        return binding.root
    }
}