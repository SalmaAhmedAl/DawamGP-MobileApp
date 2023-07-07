package com.example.dawam.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.FragmentAboutUsBinding
import com.example.dawam.ui.about.about_us3.AboutUs3Fragment
import com.example.dawam.ui.about.about_us1.AboutUs1Fragment
import com.example.dawam.ui.about.about_us2.AboutUs2Fragment

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
        var k = 1
        showFragment1()
        viewBinding.content.next.setOnClickListener {
            if(k==1){
                k++
                showFragment2()
            }else if(k==2){
                k++
                showFragment3()
            }
        }
        viewBinding.content.previous.setOnClickListener {
            if(k==3){
                k--
                showFragment2()
            }else if(k==2){
                k--
                showFragment1()
            }
        }
        var textView =viewBinding.title
        val anim = ScaleAnimation(
            0f, 1f, // Start and end values for the X axis scaling
            0f, 1f, // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f // Pivot point of Y scaling
        )
        anim.duration = 500
        textView.startAnimation(anim)
    }
    private fun showFragment1() {
        val aboutFragment1 = AboutUs1Fragment()
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragment_about_us_container, aboutFragment1, "fragmnetId")
            ?.commit()
    }
    private fun showFragment2() {
        val aboutFragment2 = AboutUs2Fragment()
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragment_about_us_container, aboutFragment2, "fragmnetId")
            ?.commit()
    }
    private fun showFragment3() {
        val aboutFragment3 = AboutUs3Fragment()
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.replace(R.id.fragment_about_us_container, aboutFragment3, "fragmnetId")
            ?.commit()
    }
}