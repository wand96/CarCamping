package com.example.carcamping.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.carcamping.R
import com.example.carcamping.base.BaseActivity
import com.example.carcamping.databinding.ActivitySplashBinding
import com.example.carcamping.ui.home.HomeActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        routeHomeActivity()
    }


    private fun routeHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
                startActivity(intent)
            },
            DELAY_ROUTE_TIME
        )
    }

    companion object {
        private const val DELAY_ROUTE_TIME = 1500L

    }
}

