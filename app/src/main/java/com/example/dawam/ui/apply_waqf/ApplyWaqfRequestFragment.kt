package com.example.dawam.ui.apply_waqf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dawam.R
import com.example.dawam.databinding.FragmentApplyWaqfRequestBinding
import com.example.dawam.ui.about.about_us1.AboutUs1Fragment


class ApplyWaqfRequestFragment : Fragment() {
    var viewBinding: FragmentApplyWaqfRequestBinding? = null
    lateinit var viewModel :ApplayWaqfRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentApplyWaqfRequestBinding.inflate(inflater, container, false)
        return viewBinding!!.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplayWaqfRequestViewModel::class.java)
        viewBinding?.vm =viewModel

    }




}