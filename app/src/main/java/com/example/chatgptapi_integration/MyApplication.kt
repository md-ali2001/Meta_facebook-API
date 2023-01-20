package com.example.chatgptapi_integration

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
@Suppress("DEPRECATION")
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
    }
}