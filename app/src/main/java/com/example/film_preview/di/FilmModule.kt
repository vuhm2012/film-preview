package com.example.film_preview.di

import android.content.Context
import com.example.film_preview.data.api.ApiService
import com.example.film_preview.repository.TrendingFilmRepository
import com.example.film_preview.view_model.TrendingFilmViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FilmModule(
    private val context: Context
) {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }

    @Singleton
    @Provides
    fun provideTrendingFilmRepository(): TrendingFilmRepository {
        return TrendingFilmRepository(provideApiService())
    }

    @Singleton
    @Provides
    fun provideTrendingFilmViewModel(): TrendingFilmViewModel {
        return TrendingFilmViewModel(provideTrendingFilmRepository())
    }

}