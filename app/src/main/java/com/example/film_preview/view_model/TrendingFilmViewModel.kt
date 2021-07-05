package com.example.film_preview.view_model

import androidx.lifecycle.ViewModel
import com.example.film_preview.repository.TrendingFilmRepository
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.TimeWindow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendingFilmViewModel @Inject constructor(
    private val trendingFilmRepository: TrendingFilmRepository
) : ViewModel() {

    fun getTrending(
        mediaType: String = MediaType.ALL.toString(),
        timeWindow: String = TimeWindow.DAY.toString()
    ) =
        trendingFilmRepository.getTrending(mediaType, timeWindow)

}