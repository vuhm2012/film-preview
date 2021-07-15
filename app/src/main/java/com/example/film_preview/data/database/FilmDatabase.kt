package com.example.film_preview.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.film_preview.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class FilmDatabase: RoomDatabase() {

    abstract fun getFavouriteFilmDao(): FavouriteFilmDao

}