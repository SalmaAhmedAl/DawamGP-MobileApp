package com.example.dawam.ui.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FragmentSubmitRequestBinding


class SubmitRequestFragment : Fragment() {
    lateinit var viewBinding: FragmentSubmitRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSubmitRequestBinding.inflate(inflater, container, false)
        return viewBinding.root
    }


}