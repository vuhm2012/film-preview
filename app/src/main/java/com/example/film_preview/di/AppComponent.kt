package com.example.film_preview.di

import android.app.Application
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.ui.favourite.FavouriteFragment
import com.example.film_preview.ui.film_detail.FilmDetailActivity
import com.example.film_preview.ui.home.HomeFragment
import com.example.film_preview.ui.search.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(filmDetailActivity: FilmDetailActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(favouriteFragment: FavouriteFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}