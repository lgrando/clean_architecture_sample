package com.example.architecture.core

import android.app.Application
import com.example.architecture.core.di.DependencyModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(DependencyModules.appModule)
        }
    }
}