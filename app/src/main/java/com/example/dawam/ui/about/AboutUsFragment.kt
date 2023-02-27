package com.example.dawam.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentAboutUsBinding

class AboutUsFragment :Fragment(){
    lateinit var viewBinding: FragmentAboutUsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       viewBinding= FragmentAboutUsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

}