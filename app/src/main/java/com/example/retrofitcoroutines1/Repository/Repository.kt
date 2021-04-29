package com.example.retrofitcoroutines1.Repository

import com.example.retrofitcoroutines1.api.RetrofitInstance
import com.example.retrofitcoroutines1.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
       return RetrofitInstance.api.getPost()
    }
}