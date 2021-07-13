package com.example.film_preview.data.api

import com.example.film_preview.model.TrendingResult
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.TimeWindow
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("trending/{media_type}/{time_window}")
    fun getTrending(
        @Path("media_type") mediaType: String = MediaType.ALL.toString(),
        @Path("time_window") timeWindow: String = TimeWindow.WEEK.toString(),
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
    ): Single<TrendingResult>

    @GET("search/movie")
    fun searchMovie(
        @Query("query") searchQuery: String = "",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): Single<TrendingResult>

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "ff19c02b4cdae6a720f195f2b3ff17ae"

        fun create(): ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)

    }

}