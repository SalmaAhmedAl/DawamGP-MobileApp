package com.example.dawam.ui.about.about_us2

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
import com.example.dawam.databinding.FrameAboutUs2Binding


class AboutUs2Fragment : Fragment() {

    lateinit var viewBinding: FrameAboutUs2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FrameAboutUs2Binding.inflate(inflater, container, false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.aboutText2.text="الوقف: هو حبس الأصل، وتسبيل المنفعة\n" +
                "وللوقف أنواع:" +
                " -وقف خيري: ويكون ريعه مخصصاً للإنفاق على وجوه البر الخاصة والعامة\n" +
                "-وقف أهلي: يكون ريعه مخصصاً للإنفاق على ذرية الواقف ونسله من بعده إلى حين انقراضهم فيؤول إلى الخيرات وجهات البر\n" +
                "-وقف مختلط: و هو مزيج بين الخيري والأهلي وكان الأغلب في مصر.\n" +
                "\n"

        val myImageView: ImageView = viewBinding.aboutUsImg2

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