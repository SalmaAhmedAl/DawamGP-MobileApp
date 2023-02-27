package com.example.dawam.ui.waqf_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dawam.databinding.ActivityWaqfDetailsBinding
import com.example.dawam.ui.Constants

class WaqfDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityWaqfDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityWaqfDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

       val waqfName = intent.getStringExtra(Constants.WAQF_NAME_EXTRA)
      // val waqfImage = intent.getIntExtra(Constants.WAQF_IMAGE_EXTRA)

       viewBinding.content.waqfName.text=waqfName

    }
}