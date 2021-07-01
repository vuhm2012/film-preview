package com.example.film_preview.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

abstract class BaseFragment: Fragment() {

    private lateinit var binding: ViewDataBinding
    var fragmentActivity: FragmentActivity? = null
    var baseContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        fragmentActivity = activity
        baseContext = activity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControls(view, savedInstanceState)
        initEvent()
    }

    abstract fun getLayoutId(): Int

    abstract fun initControls(view: View, savedInstanceState: Bundle?)

    abstract fun initEvent()

    fun getViewBinding(): ViewDataBinding {
        return binding
    }


}