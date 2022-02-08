package com.example.venue

import android.app.Application
import com.example.venue.data.di.DependencyInjectorImpl

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    val getAppDataBase by lazy {
        DependencyInjectorImpl.getAppDataBase(applicationContext)
    }
}