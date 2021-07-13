package com.example.film_preview.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.film_preview.ui.film_detail.FilmDetailActivity
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentHomeBinding
import com.example.film_preview.model.Movie
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.utils.MediaType
import com.example.film_preview.utils.TimeWindow
import javax.inject.Inject

class HomeFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    @Inject
    lateinit var trendingResult: TrendingResultViewModel
    private lateinit var adapter: HomeAdapter
    private var mediaType: String = MediaType.ALL.toString()
    private var timeWindow: String = TimeWindow.WEEK.toString()

    private val binding: FragmentHomeBinding
        get() = (getViewBinding() as FragmentHomeBinding)

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun initControls(view: View, savedInstanceState: Bundle?) {
        adapter = HomeAdapter(requireContext(), onClick)
        trendingResult.currentPage = 1
        trendingResult.currentPageLiveData.value = trendingResult.currentPage
        trendingResult.currentPageLiveData.observe(viewLifecycleOwner) { page ->
            binding.btnPrevious.isEnabled = page != 1
            trendingResult.getTrending(page = page).observe(viewLifecycleOwner) {
                adapter.setData(it.movies)
                adapter.notifyDataSetChanged()
                binding.rcvHome.adapter = adapter
                binding.txtPage.text = page.toString() + "/" + it.totalPages
                binding.btnNext.isEnabled = page != it.totalPages
            }
        }

        binding.rcvHome.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapter
        }

        createSpinners()
    }

    override fun initEvent() {
        binding.spinnerMediaType.onItemSelectedListener = this
        binding.spinnerTimeWindow.onItemSelectedListener = this
        binding.btnNext.setOnClickListener {
            trendingResult.currentPageLiveData.value = ++trendingResult.currentPage
        }

        binding.btnPrevious.setOnClickListener {
            trendingResult.currentPageLiveData.value = --trendingResult.currentPage
        }
    }

    private fun createSpinners() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.media_type_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinnerMediaType.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.time_window,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinnerTimeWindow.adapter = adapter
        }

    }

    private val onClick: (Movie) -> Unit = { movie ->
        val intent = Intent(activity, FilmDetailActivity::class.java)
        intent.putExtra("MOVIE", movie)
        startActivity(intent)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mediaType = binding.spinnerMediaType.selectedItem.toString()
        timeWindow = binding.spinnerTimeWindow.selectedItem.toString()
        trendingResult.getTrending(mediaType, timeWindow, 1).observe(viewLifecycleOwner) {
            adapter.setData(it.movies)
            adapter.notifyDataSetChanged()
            binding.rcvHome.adapter = adapter
            trendingResult.currentPage = 1
            trendingResult.currentPageLiveData.value = trendingResult.currentPage
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}