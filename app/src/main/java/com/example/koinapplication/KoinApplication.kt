package com.example.koinapplication

import android.app.Application
import com.example.koinapplication.repo.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@KoinApplication)
            modules(arrayListOf(networkModule))
        }
    }
}