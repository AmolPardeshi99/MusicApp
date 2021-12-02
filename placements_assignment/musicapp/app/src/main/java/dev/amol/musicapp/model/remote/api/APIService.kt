package dev.amol.adresssearchapp.data.remote

import dev.amol.musicapp.model.remote.responsedata.ResponseData
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    // https://itunes.apple.com/search?term=baby
    @GET("search")
    suspend fun getMusicDataFromAPI(
        @Query("term") term:String,
    ): ResponseData

}