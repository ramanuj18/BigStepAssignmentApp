package com.example.bigstepassignmentapp.ui.main.view.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.bigstepassignmentapp.R
import com.example.bigstepassignmentapp.databinding.ActivityTabbedBinding
import com.example.bigstepassignmentapp.ui.main.adapter.SectionsPagerAdapter
import com.example.bigstepassignmentapp.ui.main.viewmodel.VideosViewModel
import com.example.bigstepassignmentapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabbedActivity : AppCompatActivity() {

    val videoViewModel: VideosViewModel by viewModels()
    private lateinit var binding: ActivityTabbedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabbed)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        videoViewModel.fetchVideos()

    }
}