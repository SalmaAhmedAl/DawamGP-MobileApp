package com.example.dawam.ui.about.aboutBlockChain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentAboutBlockChainBinding


class AboutBlockChainFragment : Fragment() {

    lateinit var viewBinding: FragmentAboutBlockChainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentAboutBlockChainBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


}