package com.example.film_preview.data.database

import androidx.room.*
import com.example.film_preview.model.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FavouriteFilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavourite(movie: Movie):Completable

    @Delete
    fun removeFavourite(movie: Movie)

    @Query("SELECT * FROM favourite_film_table")
    fun getAllFavourite(): Observable<List<Movie>>

}