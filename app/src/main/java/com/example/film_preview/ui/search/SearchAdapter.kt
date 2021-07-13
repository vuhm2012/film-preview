package com.example.film_preview.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.film_preview.R
import com.example.film_preview.model.Movie

class SearchAdapter(
    private val context: Context,
    private val onClick: (Movie) -> Unit
): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val posterPath = "http://image.tmdb.org/t/p/original"
    private var films: List<Movie> = listOf()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_film_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 2

}