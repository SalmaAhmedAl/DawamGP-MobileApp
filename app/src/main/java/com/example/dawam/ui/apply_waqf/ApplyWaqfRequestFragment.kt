package com.example.dawam.ui.apply_waqf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentApplyWaqfRequestBinding


class ApplyWaqfRequestFragment : Fragment() {
    lateinit var viewBinding: FragmentApplyWaqfRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentApplyWaqfRequestBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


}