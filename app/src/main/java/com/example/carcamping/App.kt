package com.example.carcamping

import android.app.Application
import com.example.carcamping.di.AppKoinSetup
import com.example.carcamping.di.KoinBaseKoinSetup

class App : Application() {

    private val appKoinSetup: KoinBaseKoinSetup = AppKoinSetup()

    override fun onCreate() {
        super.onCreate()
        appKoinSetup.setup(this)
    }
}