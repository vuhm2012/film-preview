package com.example.film_preview.di

import com.example.film_preview.data.api.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(

) {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }

}