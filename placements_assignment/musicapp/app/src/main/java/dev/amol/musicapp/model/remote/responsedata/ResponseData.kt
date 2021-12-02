package dev.amol.musicapp.model.remote.responsedata


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)