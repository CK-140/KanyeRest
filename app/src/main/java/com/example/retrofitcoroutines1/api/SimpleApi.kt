package com.example.retrofitcoroutines1.api

import com.example.retrofitcoroutines1.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("https://api.kanye.rest/")
    suspend fun getPost(): Response<Post>
}