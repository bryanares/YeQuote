package com.brian.tellinye.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.brian.tellinye.databinding.FragmentQuotesBinding
import com.brian.tellinye.network.Ye


class QuotesFragment : Fragment() {

    private val viewModel: YeViewModel by activityViewModels()
//    private var _binding: FragmentQuotesBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
      val binding = FragmentQuotesBinding.inflate(inflater, container, false)

        //call viewmodel method
        viewModel.getYeQuote()
        binding.lifecycleOwner = this
//        val text = binding.ye?.quote
//        binding.quoteTextView.text = text

        binding.quoteButton.setOnClickListener {
            viewModel.getYeQuote()
        }
        val view = binding.root
        return view
    }
}