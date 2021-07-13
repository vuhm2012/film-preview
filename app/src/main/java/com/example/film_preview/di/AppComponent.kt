package com.example.film_preview.di

import android.app.Application
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.ui.home.HomeFragment
import com.example.film_preview.ui.search.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(seachFragment: SearchFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}