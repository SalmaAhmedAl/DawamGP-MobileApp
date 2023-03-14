package com.example.dawam.ui.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dawam.R
import com.example.dawam.databinding.FragmentSubmitRequestBinding


class SubmitRequestFragment : Fragment() {
    lateinit var viewModel: SubmitRequestViewModel
    lateinit var viewBinding: FragmentSubmitRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_submit_request, container, false
        )
        return viewBinding.root

        viewModel = ViewModelProvider(this).get(SubmitRequestViewModel::class.java)
        viewBinding.vm = viewModel
    }


}