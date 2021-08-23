package com.example.app1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search")
    //Call<ResponseModel> getSong(@Query("term") String term)
    fun getSong(@Query("term") term :String): Call<ResponseModel>
}