package com.example.bigstepassignmentapp.ui.main.view.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bigstepassignmentapp.R
import com.example.bigstepassignmentapp.data.model.Video
import com.example.bigstepassignmentapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val video = intent.getParcelableExtra<Video>("video")

        video?.let {
            binding.video = it
            Picasso.get().load(it.artworkUrl100).into(binding.imageView)

            binding.textViewPriceValue.text = "${it.currency} ${it.trackPrice}"

        }
    }
}