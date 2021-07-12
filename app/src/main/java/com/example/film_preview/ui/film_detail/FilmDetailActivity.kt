package com.example.film_preview.ui.film_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.film_preview.R
import com.example.film_preview.base.BaseActivity
import com.example.film_preview.databinding.ActivityFilmDetailBinding
import com.example.film_preview.model.Movie

class FilmDetailActivity : BaseActivity() {

    private val binding: ActivityFilmDetailBinding
        get() = (getViewBinding() as ActivityFilmDetailBinding)

    private val imagePath = "http://image.tmdb.org/t/p/original"

    override fun getLayoutId(): Int = R.layout.activity_film_detail

    override fun initControls(savedInstanceState: Bundle?) {
        var movie: Movie = intent.getSerializableExtra("MOVIE") as Movie
        binding.toolbarDetail.title = movie.title
        setSupportActionBar(binding.toolbarDetail)
        Glide.with(this).load(imagePath + movie.backdropPath).into(binding.imgBackdropDetail)
        Glide.with(this).load(imagePath + movie.posterPath).into(binding.imgPosterDetail)
        binding.txtTitleDetail.text = movie.title
        binding.txtRating.text = resources.getText(R.string.rating).toString() + " " + movie.voteAverage.toString()
        binding.txtReleaseDateDetail.text = movie.releaseDate
        binding.txtOverviewDetail.text = movie.overview
        if(movie.adult) {
            binding.txtIsAdult.visibility = View.VISIBLE
        }

    }

    override fun initEvents() {
        binding.toolbarDetail.setNavigationOnClickListener {
            finish()
        }
    }

}