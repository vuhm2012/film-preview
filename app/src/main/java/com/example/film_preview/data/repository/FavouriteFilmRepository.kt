package com.example.film_preview.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.example.film_preview.data.database.FavouriteFilmDao
import com.example.film_preview.model.Movie
import com.example.film_preview.utils.toLiveData
import io.reactivex.BackpressureStrategy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavouriteFilmRepository @Inject constructor(private val favouriteFilmDao: FavouriteFilmDao) {

    fun addFavourite(movie: Movie) = favouriteFilmDao.addFavourite(movie)

    fun removeFavourite(movie: Movie) = favouriteFilmDao.removeFavourite(movie)

    fun getAllFavourite()= favouriteFilmDao.getAllFavourite()
}