package com.example.dawam.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.dawam.R
import com.example.dawam.databinding.ActivitySplashBinding
import com.example.dawam.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(viewBinding.root)
        viewBinding= DataBindingUtil.setContentView(this,R.layout.activity_splash)
        with(viewBinding.logo) {
            alpha=0f
            animate().setDuration(1500).alpha(1f).withEndAction{
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()

            }
        }

    }
}