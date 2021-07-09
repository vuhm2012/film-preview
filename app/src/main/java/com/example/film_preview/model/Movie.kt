package com.example.film_preview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_film_table")
data class Movie(
    var title: String = "",
    var originalTitle: String = "",
    var posterPath: String = "",
    var adult: Boolean = false,
    var overview: String = "",
    var releaseDate: String = "",
    var genreIds: List<Integer> = listOf(),
    var originalLanguage: String = "",
    var backdropPath: String = "",
    var popularity: Long = 0,
    var voteCount: Int = 0,
    var video: Boolean = false,
    var voteAverage: Long = 0
) {
    @PrimaryKey
    var id: Long = 0
}
