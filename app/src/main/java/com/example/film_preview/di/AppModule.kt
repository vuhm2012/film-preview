package com.example.film_preview.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.film_preview.data.api.ApiService
import com.example.film_preview.data.database.FavouriteFilmDao
import com.example.film_preview.data.database.FilmDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }

    @Singleton
    @Provides
    fun provideDatabase(application: Application): FilmDatabase =
        Room.databaseBuilder(
            application.applicationContext,
            FilmDatabase::class.java,
            "MovieDB.db"
        ).build()

    @Singleton
    @Provides
    fun provideDao(application: Application): FavouriteFilmDao =
        provideDatabase(application).getFavouriteFilmDao()

}