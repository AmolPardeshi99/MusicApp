package com.example.app1


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("resultCount")
    val resultCount: Int?,
    @SerializedName("results")
    val results: List<Result>?
)