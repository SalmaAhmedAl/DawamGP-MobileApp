package com.example.dawam.ui.contactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentContactUsBinding

class ContactUsFragment :Fragment(){
    lateinit var viewBinding: FragmentContactUsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding= FragmentContactUsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}