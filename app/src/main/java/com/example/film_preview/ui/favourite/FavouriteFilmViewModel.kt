package com.example.film_preview.ui.favourite

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.film_preview.model.Movie
import com.example.film_preview.data.repository.FavouriteFilmRepository
import com.example.film_preview.utils.toLiveData
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavouriteFilmViewModel @Inject constructor(private val favouriteFilmRepository: FavouriteFilmRepository) :
    ViewModel() {

    fun addFavourite(movie: Movie) = favouriteFilmRepository.addFavourite(movie)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            Log.d("TAG", "addFavourite: Done")
        }

    fun removeFavourite(movie: Movie) = favouriteFilmRepository.removeFavourite(movie)

    fun getAllFavourite(): LiveData<List<Movie>> =
        favouriteFilmRepository.getAllFavourite().subscribeOn(Schedulers.io())
            .toLiveData(BackpressureStrategy.LATEST)

}