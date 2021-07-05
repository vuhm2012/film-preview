package com.example.film_preview.utils

enum class TimeWindow(private val des: String) {
    DAY("day"),
    WEEK("week");

    override fun toString(): String {
        return des
    }
}