package com.example.film_preview.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.film_preview.model.FilmDetail
import com.example.film_preview.repository.FavouriteFilmRepository
import javax.inject.Inject

class FavouriteFilmViewModel @Inject constructor(private val favouriteFilmRepository: FavouriteFilmRepository) : ViewModel() {

    fun addFavourite(filmDetail: FilmDetail) = favouriteFilmRepository.addFavourite(filmDetail)

    fun removeFavourite(filmDetail: FilmDetail) = favouriteFilmRepository.removeFavourite(filmDetail)

    fun getAllFavourite(): LiveData<List<FilmDetail>> = favouriteFilmRepository.getAllFavourite()

}