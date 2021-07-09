package com.example.film_preview.data.database

import androidx.room.*
import com.example.film_preview.model.Movie
import io.reactivex.Flowable

@Dao
interface FavouriteFilmDao {

    @Insert
    fun addFavourite(movie: Movie)

    @Delete
    fun removeFavourite(movie: Movie)

    @Query("SELECT * FROM favourite_film_table")
    fun getAllFavourite(): Flowable<List<Movie>>

}