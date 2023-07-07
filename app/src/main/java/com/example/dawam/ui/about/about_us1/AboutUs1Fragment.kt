package com.example.dawam.ui.about.about_us1

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.dawam.R
import com.example.dawam.databinding.ActivityHomeBinding
import com.example.dawam.databinding.FrameAboutUs1Binding
import com.example.dawam.ui.home.HomeActivity
import com.example.dawam.ui.home.HomeFragment


class AboutUs1Fragment : Fragment() {
    lateinit var viewBinding: FrameAboutUs1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FrameAboutUs1Binding.inflate(inflater, container, false)
        val callback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showFragment(HomeFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myImageView: ImageView = viewBinding.aboutUsImg1

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

    fun showFragment(fragment: Fragment) {
        val context = requireContext()
        val transition = TransitionInflater.from(context).inflateTransition(android.R.transition.fade)
        fragment.enterTransition = transition
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }


}