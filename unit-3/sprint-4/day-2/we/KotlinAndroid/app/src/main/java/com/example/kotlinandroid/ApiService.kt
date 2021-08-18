package com.example.kotlinandroid

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("comments")
    fun getPosts(@Query("postId") postId: Int): Call<List<ResponseDTO>>
}