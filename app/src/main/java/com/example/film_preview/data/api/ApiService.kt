package com.example.film_preview.data.api

import com.example.film_preview.model.FilmDetail
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.TimeWindow
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/trending/{media_type}/{time_window}")
    fun getTrending(
        @Path("media_type") mediaType: String = MediaType.ALL.toString(),
        @Path("time_window") timeWindow: String = TimeWindow.DAY.toString()
    ): Flowable<List<FilmDetail>>

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)

    }

}