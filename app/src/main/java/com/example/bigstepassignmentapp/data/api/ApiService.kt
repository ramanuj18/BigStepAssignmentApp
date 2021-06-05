package com.example.bigstepassignmentapp.data.api

import com.example.bigstepassignmentapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * created by Ramanuj Kesharawani on 4/6/21
 */
interface ApiService {

    @GET("/search?term=Michael+jackson&amp;media=musicVideo")
    suspend fun getVideos(): Response<ApiResponse>
}