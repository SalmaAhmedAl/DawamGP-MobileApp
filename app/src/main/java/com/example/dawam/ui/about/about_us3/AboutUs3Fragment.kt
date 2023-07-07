package com.example.dawam.ui.about.about_us3

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.dawam.databinding.FrameAboutUs3Binding


class AboutUs3Fragment : Fragment() {

    lateinit var viewBinding: FrameAboutUs3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FrameAboutUs3Binding.inflate(inflater, container, false)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myImageView: ImageView = viewBinding.aboutUsImg3
        val valueAnimator = ValueAnimator.ofFloat(1f, 1.2f, 1f)
        valueAnimator.duration = 3000 // بالمللي ثانية
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            myImageView.scaleX = value
            myImageView.scaleY = value
        }
        valueAnimator.start()
    }


}