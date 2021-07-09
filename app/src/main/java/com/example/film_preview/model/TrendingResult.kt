package com.example.film_preview.model

import com.google.gson.annotations.SerializedName

data class TrendingResult(
    @SerializedName("page") var page: Int,
    @SerializedName("results")var movies: List<Movie>,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("total_results") var totalResult: Int
)