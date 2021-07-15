package com.example.film_preview.ui.favourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.film_preview.R
import com.example.film_preview.model.Movie

class FavouriteAdapter(
    private val context: Context
): RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    private val posterPath = "http://image.tmdb.org/t/p/original"
    private var films: List<Movie> = listOf()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val text: TextView = itemView.findViewById(R.id.txt_title)
        private val imgPoster: ImageView = itemView.findViewById(R.id.img_poster_home)

        fun onBind(movie: Movie) {
            text.text = movie.title
            Glide.with(context).load(posterPath + movie.posterPath).into(imgPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.film_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(films[position])
    }

    override fun getItemCount(): Int = films.size

    fun setData(films: List<Movie>) {
        this.films = films
    }

}