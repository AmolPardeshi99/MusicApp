package com.example.kotlin_scoping_functions

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("api/users/")
    fun getUserDetails(@Query("page") pageNo :Int): Call<ResponseDTO>
}