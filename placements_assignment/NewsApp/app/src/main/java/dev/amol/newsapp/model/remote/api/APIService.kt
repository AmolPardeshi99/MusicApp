package dev.amol.newsapp.model.remote.api

import dev.amol.newsapp.model.Utility
import dev.amol.newsapp.model.Utility.TOP_HEADLINE
import dev.amol.newsapp.model.remote.responsedata.ResponseData
import retrofit2.http.GET

interface APIService {

    @GET(TOP_HEADLINE)
    suspend fun getNewsFromAPI():ResponseData

}