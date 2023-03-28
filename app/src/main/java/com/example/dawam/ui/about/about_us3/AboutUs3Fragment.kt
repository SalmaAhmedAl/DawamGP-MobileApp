package com.example.dawam.ui.about.about_us3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FrameAboutUs3Binding


class AboutUs3Fragment : Fragment() {

    lateinit var viewBinding: FrameAboutUs3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FrameAboutUs3Binding.inflate(inflater, container, false)
        return viewBinding.root
    }


}