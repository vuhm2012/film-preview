package com.example.film_preview.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_film_table")
data class Movie(
    @SerializedName(alternate = ["name"], value = "title") var title: String = "",
    @SerializedName(alternate = ["original_name"], value = "original_title") var originalTitle: String = "",
    @SerializedName("poster_path") var posterPath: String = "",
    @SerializedName("adult") var adult: Boolean = false,
    @SerializedName("over_view") var overview: String = "",
    @SerializedName("release_date") var releaseDate: String = "",
    @SerializedName("genre_ids") var genreIds: List<Integer> = listOf(),
    @SerializedName("original_language") var originalLanguage: String = "",
    @SerializedName("backdrop_path") var backdropPath: String = "",
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("video") var video: Boolean = false,
    @SerializedName("vote_average") var voteAverage: Double = 0.0
) {
    @PrimaryKey
    @SerializedName("id")  var id: Int = 0
}
