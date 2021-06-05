package com.example.bigstepassignmentapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bigstepassignmentapp.R
import com.example.bigstepassignmentapp.data.model.Video
import com.example.bigstepassignmentapp.databinding.VideoItemLayoutBinding

/**
 * created by Ramanuj Kesharawani on 5/6/21
 */
class VideoRecyclerAdapter(private var list: List<Video> = listOf(),private val onItemClick:(Video) -> Unit): RecyclerView.Adapter<VideoRecyclerAdapter.ViewHolder>() {

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

        holder.binding.root.setOnClickListener {
            onItemClick(video)
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