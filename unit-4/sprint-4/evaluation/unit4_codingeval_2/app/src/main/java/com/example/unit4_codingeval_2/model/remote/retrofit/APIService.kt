package com.example.unit4_codingeval_2.model.remote.retrofit

import com.example.unit4_codingeval_2.model.remote.model.PizzaResponseModel
import retrofit2.http.GET

interface APIService {

    @GET("pizzas")
    suspend fun getAllPizzaData():PizzaResponseModel


}