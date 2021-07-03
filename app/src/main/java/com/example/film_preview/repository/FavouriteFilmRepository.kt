package com.example.film_preview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.example.film_preview.data.database.FavouriteFilmDao
import com.example.film_preview.model.FilmDetail
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavouriteFilmRepository @Inject constructor(private val favouriteFilmDao: FavouriteFilmDao) {

    fun addFavourite(filmDetail: FilmDetail) = favouriteFilmDao.addFavourite(filmDetail)

    fun removeFavourite(filmDetail: FilmDetail) = favouriteFilmDao.removeFavourite(filmDetail)

    fun getAllFavourite(): LiveData<List<FilmDetail>> = LiveDataReactiveStreams.fromPublisher(
        favouriteFilmDao.getAllFavourite().subscribeOn(
            Schedulers.io()
        )
    )
}