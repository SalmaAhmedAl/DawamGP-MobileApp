package com.example.dawam.ui.contact_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.FragmentContactUsBinding
import com.example.dawam.ui.contact_us.recyclerview.ItemAdapter
import com.example.dawam.ui.contact_us.recyclerview.itemDM

class ContactUsFragment :Fragment(){
    lateinit var viewBinding: FragmentContactUsBinding
    lateinit var adpater:ItemAdapter
    var items = listOf(
        itemDM(
            R.drawable.website_ic,
            contactText ="https://www.example.org"
        ),
        itemDM(
            R.drawable.facebook_icon,
            contactText ="https://www.facebook.com/DWAM"
        ),
        itemDM(
            R.drawable.instagram_icon,
            contactText ="دوام / DWAM"
        ),
        itemDM(
            R.drawable.icon_twitter,
            contactText ="دوام / DWAM"
        ),
        itemDM(
            R.drawable.linkedin_icon,
            contactText ="دوام / DWAM"
        ),
        itemDM(
            R.drawable.phone_icon,
            contactText ="+20-11-xxxx-xxxx"
        )

        )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding= FragmentContactUsBinding.inflate(inflater, container, false)
        return viewBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adpater=ItemAdapter(items)
        viewBinding.content.contactUsRecycler.adapter=adpater
    }
}