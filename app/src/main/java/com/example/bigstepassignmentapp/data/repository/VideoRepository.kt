package com.example.bigstepassignmentapp.data.repository

import com.example.bigstepassignmentapp.data.api.ApiService
import com.example.bigstepassignmentapp.data.db.AppDatabase
import com.example.bigstepassignmentapp.data.model.Video
import javax.inject.Inject

/**
 * created by Ramanuj Kesharawani on 5/6/21
 */
class VideoRepository @Inject constructor(private val apiService: ApiService, private var appDatabase: AppDatabase){

    suspend fun getVideos() = apiService.getVideos()

    fun getVideoHistory() = appDatabase.videoDao().selectAll()

    fun insertVideo(video: Video) = appDatabase.videoDao().insert(video)
}