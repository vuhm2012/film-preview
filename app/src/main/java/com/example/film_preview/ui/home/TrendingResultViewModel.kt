package com.example.film_preview.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.film_preview.data.repository.TrendingResultRepository
import com.example.film_preview.model.TrendingResult
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.Resource
import com.example.film_preview.utils.TimeWindow
import com.example.film_preview.utils.toLiveData
import io.reactivex.schedulers.Schedulers
import java.lang.Error
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendingResultViewModel @Inject constructor(
    private val trendingResultRepository: TrendingResultRepository
) : ViewModel() {

    fun getTrending(
        mediaType: String = MediaType.ALL.toString(),
        timeWindow: String = TimeWindow.WEEK.toString(),
        page: Int = 1
    ): LiveData<TrendingResult> =
        trendingResultRepository.getTrending(mediaType, timeWindow, page)
            .subscribeOn(Schedulers.io())
            .toLiveData()

}