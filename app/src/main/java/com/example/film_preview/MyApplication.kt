package com.example.film_preview

import android.app.Application
import com.example.film_preview.di.AppComponent
import com.example.film_preview.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
    }

}