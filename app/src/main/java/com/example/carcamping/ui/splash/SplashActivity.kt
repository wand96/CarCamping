package com.example.carcamping.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.carcamping.R
import com.example.carcamping.ui.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, HomeActivity::class.java).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
            startActivity(intent)
        }, 1500)
    }

}