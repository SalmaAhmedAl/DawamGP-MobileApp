package com.example.dawam.ui.about.aboutawqaf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentAboutawqafBinding


class AboutawqafFragment : Fragment() {
    lateinit var viewBinding: FragmentAboutawqafBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentAboutawqafBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


}