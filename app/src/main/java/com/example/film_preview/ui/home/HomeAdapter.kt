package com.example.film_preview.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.film_preview.R
import com.example.film_preview.model.FilmDetail

class HomeAdapter(
    private val context: Context,
    private val onClick: (FilmDetail) -> Unit
): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var films: List<FilmDetail> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.home_film_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.onBind(films[position], onClick)
    }

    override fun getItemCount(): Int = films.size

    fun setData(films: List<FilmDetail>) {
        this.films = films
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var text: TextView = itemView.findViewById(R.id.text)

        fun onBind(filmDetail: FilmDetail, onClick: (FilmDetail) -> Unit) {
            text.text = filmDetail.posterPath
        }

    }


}