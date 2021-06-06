package com.example.bigstepassignmentapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bigstepassignmentapp.data.model.Video

/**
 * created by Ramanuj Kesharawani on 5/6/21
 */
@Dao
interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(video: Video): Long

    @Query("select * from video")
    fun selectAll(): LiveData<List<Video>>

    @Delete
    fun deleteVideo(video: Video):Int
}