package com.example.scopingfunction


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  ApiService {

    @GET("/api/users/{ID}")
    fun getUserDetails(@Path("ID") id: Int): Call<ResponseDTO>
}