package com.example.film_preview.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentHomeBinding
import com.example.film_preview.model.FilmDetail
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.view_model.TrendingFilmViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding
        get() = (getViewBinding() as FragmentHomeBinding)

    private lateinit var adapter: HomeAdapter
//    @Inject lateinit var trendingFilmViewModel: TrendingFilmViewModel

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initControls(view: View, savedInstanceState: Bundle?) {
        adapter = HomeAdapter(requireContext(), onClick)

        binding.rcvHome.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapter
        }
//        trendingFilmViewModel.getTrending()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                adapter.setData(it)
//                adapter.notifyDataSetChanged()
//            }


    }

    override fun initEvent() {

    }


    private val onClick: (FilmDetail) -> Unit = {

    }

}