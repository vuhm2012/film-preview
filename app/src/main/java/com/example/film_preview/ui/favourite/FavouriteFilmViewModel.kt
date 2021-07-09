package com.example.film_preview.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.film_preview.model.Movie
import com.example.film_preview.data.repository.FavouriteFilmRepository
import javax.inject.Inject

class FavouriteFilmViewModel @Inject constructor(private val favouriteFilmRepository: FavouriteFilmRepository) : ViewModel() {

    fun addFavourite(movie: Movie) = favouriteFilmRepository.addFavourite(movie)

    fun removeFavourite(movie: Movie) = favouriteFilmRepository.removeFavourite(movie)

    fun getAllFavourite(): LiveData<List<Movie>> = favouriteFilmRepository.getAllFavourite()

}