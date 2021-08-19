package com.example.a18augpostrequest_kotlin

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
    fun getPost(): Call<ResponseModel?>?

    @POST("posts")
    fun postData(@Body requestModel: RequestModel?): Call<ResponseModel?>?
}