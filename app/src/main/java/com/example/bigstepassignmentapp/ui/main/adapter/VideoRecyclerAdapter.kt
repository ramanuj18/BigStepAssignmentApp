package com.example.bigstepassignmentapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bigstepassignmentapp.R
import com.example.bigstepassignmentapp.data.model.Video
import com.example.bigstepassignmentapp.databinding.VideoItemLayoutBinding
import com.squareup.picasso.Picasso

/**
 * created by Ramanuj Kesharawani on 5/6/21
 */
class VideoRecyclerAdapter(private var list: List<Video> = listOf(),private val onClick:(Video,Int) -> Unit): RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: VideoItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<VideoItemLayoutBinding>(LayoutInflater.from(parent.context),
            R.layout.video_item_layout,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = list[position]
        holder.binding.video = video

        Picasso.get().load(video.artworkUrl60).into(holder.binding.imageView)

        holder.binding.root.setOnClickListener {
            onClick(video,1)
        }

        holder.binding.root.setOnLongClickListener {
            onClick(video,2)
            true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setVideoList(vList: List<Video>){
        this.list = vList
        notifyDataSetChanged()
    }

}