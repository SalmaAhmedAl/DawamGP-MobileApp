package com.example.dawam.ui.about.about_us1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FrameAboutUs1Binding


class AboutUs1Fragment : Fragment() {
    lateinit var viewBinding: FrameAboutUs1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FrameAboutUs1Binding.inflate(inflater, container, false)
        return viewBinding.root
    }


}