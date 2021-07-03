package com.example.film_preview.data.database

import androidx.room.Database
import com.example.film_preview.model.FilmDetail

@Database(entities = [FilmDetail::class], version = 1)
abstract class FilmDatabase {

    abstract fun getFavouriteFilmDao()

}