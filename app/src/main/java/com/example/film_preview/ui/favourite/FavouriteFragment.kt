package com.example.film_preview.ui.favourite

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentFavouriteBinding
import com.example.film_preview.ui.MainActivity
import com.example.film_preview.ui.home.HomeAdapter
import javax.inject.Inject


class FavouriteFragment : BaseFragment() {

    @Inject
    lateinit var favouriteFilmViewModel: FavouriteFilmViewModel
    private lateinit var adapter: FavouriteAdapter

    private val binding: FragmentFavouriteBinding
        get() = (getViewBinding() as FragmentFavouriteBinding)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_favourite

    override fun initControls(view: View, savedInstanceState: Bundle?) {
        adapter = FavouriteAdapter(requireContext())
        favouriteFilmViewModel.getAllFavourite().observe(viewLifecycleOwner) {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
            binding.rcvFavourite.adapter = adapter
        }

        binding.rcvFavourite.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapter
        }
    }

    override fun initEvent() {

    }

}