package com.example.film_preview.data.database

import androidx.room.*
import com.example.film_preview.model.FilmDetail
import io.reactivex.Flowable

@Dao
interface FavouriteFilmDao {

    @Insert
    fun addFavourite(filmDetail: FilmDetail)

    @Delete
    fun removeFavourite(filmDetail: FilmDetail)

    @Query("SELECT * FROM favourite_film_table")
    fun getAllFavourite(): Flowable<List<FilmDetail>>

}