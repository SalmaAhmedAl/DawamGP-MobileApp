package com.example.dawam.ui.waqf_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dawam.R
import com.example.dawam.databinding.ActivityWaqfDetailsBinding
import com.example.dawam.ui.Constants.WAQF_IMAGE_EXTRA
import com.example.dawam.ui.Constants.WAQF_NAME_EXTRA

class WaqfDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityWaqfDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityWaqfDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

       val waqfName = intent.getStringExtra(WAQF_NAME_EXTRA)
        val waqfImage = intent.getIntExtra(WAQF_IMAGE_EXTRA, R.drawable.cairo_college)

       viewBinding.content.waqfName.text=waqfName
        viewBinding.content.image.setImageResource(waqfImage)

        initListeners()

    }

    private fun initListeners() {
        with(viewBinding) {
            backBtn.setOnClickListener{
                finish()
            }
        }
    }
}