package com.yml.healthcare

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HealthCareApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}