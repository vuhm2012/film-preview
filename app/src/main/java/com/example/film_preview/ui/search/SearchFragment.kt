package com.example.film_preview.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentSearchBinding
import com.example.film_preview.model.Movie
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.ui.film_detail.FilmDetailActivity
import com.example.film_preview.ui.home.HomeAdapter
import com.example.film_preview.ui.home.TrendingResultViewModel
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    @Inject
    lateinit var trendingResult: TrendingResultViewModel
    private lateinit var adapter: HomeAdapter

    private val binding: FragmentSearchBinding
        get() = (getViewBinding() as FragmentSearchBinding)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_search

    override fun initControls(view: View, savedInstanceState: Bundle?) {
        adapter = HomeAdapter(requireContext(), onClick)
        restartPageValue()
    }

    override fun initEvent() {
        binding.tilSearch.setEndIconOnClickListener {
            restartPageValue()
            binding.pageLayout.visibility = View.VISIBLE
            var query = binding.edtSearch.text.toString()
            if(query.isBlank()) query = "a"
            trendingResult.currentPageLiveData.value = trendingResult.currentPage
            trendingResult.currentPageLiveData.observe(viewLifecycleOwner) { page ->
                binding.btnPrevious.isEnabled = page != 1
                trendingResult.searchMovie(query, page).observe(viewLifecycleOwner) {
                    adapter.setData(it.movies)
                    adapter.notifyDataSetChanged()
                    binding.rcvSearch.adapter = adapter
                    binding.txtPage.text = page.toString() + "/" + it.totalPages
                    binding.btnNext.isEnabled = page != it.totalPages
                }
            }
            binding.rcvSearch.apply {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = adapter
            }
        }

        binding.btnNext.setOnClickListener {
            trendingResult.currentPageLiveData.value = ++trendingResult.currentPage
        }

        binding.btnPrevious.setOnClickListener {
            trendingResult.currentPageLiveData.value = --trendingResult.currentPage
        }

    }

    private fun restartPageValue() {
        trendingResult.currentPage = 1
        trendingResult.currentPageLiveData.value = trendingResult.currentPage
    }

    private val onClick: (Movie) -> Unit = { movie ->
        val intent = Intent(activity, FilmDetailActivity::class.java)
        intent.putExtra("MOVIE", movie)
        startActivity(intent)
    }

}