package com.example.film_preview.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentHomeBinding
import com.example.film_preview.model.Movie
import com.example.film_preview.ui.MainActivity
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding
        get() = (getViewBinding() as FragmentHomeBinding)

    private lateinit var adapter: HomeAdapter
    @Inject
    lateinit var trendingResult: TrendingResultViewModel

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun initControls(view: View, savedInstanceState: Bundle?) {
        adapter = HomeAdapter(requireContext(), onClick)

        binding.rcvHome.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapter
        }

        trendingResult.getTrending().observe(viewLifecycleOwner) {
            adapter.setData(it.movies)
            adapter.notifyDataSetChanged()
            binding.rcvHome.adapter = adapter
        }

    }

    override fun initEvent() {

    }


    private val onClick: (Movie) -> Unit = {

    }

}