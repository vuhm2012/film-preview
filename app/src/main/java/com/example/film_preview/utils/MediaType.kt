package com.example.film_preview.utils

enum class MediaType(private val des: String) {
    ALL("all"),
    MOVIE("movie"),
    TV("tv"),
    PERSON("person");

    override fun toString(): String {
        return des
    }


}