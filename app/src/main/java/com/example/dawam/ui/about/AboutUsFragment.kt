package com.example.dawam.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.FragmentAboutUsBinding
import com.example.dawam.ui.about.aboutBlockChain.AboutBlockChainFragment
import com.example.dawam.ui.about.aboutawqaf.AboutawqafFragment

class AboutUsFragment :Fragment(){
    lateinit var viewBinding: FragmentAboutUsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAboutWaqfFragment()
        viewBinding.next.setOnClickListener {
            showblockchainFragment()
        }
        viewBinding.previous.setOnClickListener {
            showAboutWaqfFragment()
        }
    }

    fun showblockchainFragment() {
        val blockchainFragment = AboutBlockChainFragment()
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragment_aboutus_contaner, blockchainFragment, "fragmnetId")
            ?.commit()
    }

    fun showAboutWaqfFragment() {
        val AboutWaqfFragment = AboutawqafFragment()
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragment_aboutus_contaner, AboutWaqfFragment, "fragmnetId")
            ?.commit()
    }


}