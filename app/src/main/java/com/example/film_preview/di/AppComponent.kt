package com.example.film_preview.di

import android.app.Activity
import com.example.film_preview.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FilmModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}