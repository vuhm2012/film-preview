package com.example.film_preview.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.film_preview.R
import com.example.film_preview.base.BaseActivity
import com.example.film_preview.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding
        get() = (getViewBinding() as ActivityMainBinding)

    private val controller by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initControls(savedInstanceState: Bundle?) {
        binding.bottomNavigation.setupWithNavController(controller)
    }

    override fun initEvents() {

    }

}