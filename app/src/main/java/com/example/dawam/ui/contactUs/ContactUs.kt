package com.example.dawam.ui.contactUs

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dawam.R
import com.example.dawam.databinding.ActivityHomeBinding
import com.example.dawam.databinding.ItemDesignBinding
import com.example.dawam.ui.contactUs.recyclerview.itemAdapter
import com.example.dawam.ui.contactUs.recyclerview.itemDM
import com.example.dawam.ui.home.Waqf

class ContactUs:AppCompatActivity() {
    lateinit var binding: ItemDesignBinding
    lateinit var adapter: itemAdapter
    var awqaf = listOf(
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
        ),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}