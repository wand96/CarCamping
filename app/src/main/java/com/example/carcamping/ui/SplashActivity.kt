package com.example.carcamping.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.carcamping.R

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler = Handler()
        handler.postDelayed( {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }, 1500)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}