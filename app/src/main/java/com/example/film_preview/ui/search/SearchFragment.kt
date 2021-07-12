package com.example.film_preview.ui.search

import android.os.Bundle
import android.view.View
import com.example.film_preview.R
import com.example.film_preview.base.BaseFragment
import com.example.film_preview.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment() {

    private val binding: FragmentSearchBinding
        get() = (getViewBinding() as FragmentSearchBinding)

    override fun getLayoutId(): Int = R.layout.fragment_search

    override fun initControls(view: View, savedInstanceState: Bundle?) {

    }

    override fun initEvent() {

    }

}