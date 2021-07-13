package com.example.film_preview.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.film_preview.data.api.ApiService
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.TimeWindow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendingResultRepository @Inject constructor(private val apiService: ApiService) {

    fun getTrending(
        mediaType: String = MediaType.ALL.toString(),
        timeWindow: String = TimeWindow.WEEK.toString(),
        page: Int = 1
    ) = apiService.getTrending(mediaType, timeWindow, page)

    fun searchMovie(
        searchQuery: String = "",
        page: Int = 1,
    ) = apiService.searchMovie(searchQuery, page)

}