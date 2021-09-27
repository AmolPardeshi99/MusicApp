package com.example.unit4_codingeval_2.model.remote.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{
        val base_url ="https://gist.githubusercontent.com/shivarajp/04af4846333e3c61a8d84d310915c75d/raw/a8a1bd18d7ca7f59dc56784b211044864beba831/"

        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
        }
    }
}