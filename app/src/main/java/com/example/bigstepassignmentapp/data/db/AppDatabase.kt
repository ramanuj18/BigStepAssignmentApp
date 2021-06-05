package com.example.bigstepassignmentapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bigstepassignmentapp.data.db.dao.VideosDao
import com.example.bigstepassignmentapp.data.model.Video

/**
 * created by Ramanuj Kesharawani on 4/6/21
 */
@Database(entities = [Video::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun videoDao(): VideosDao
}