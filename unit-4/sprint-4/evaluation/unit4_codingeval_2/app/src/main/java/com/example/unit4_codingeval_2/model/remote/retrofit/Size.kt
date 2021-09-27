package com.example.unit4_codingeval_2.model.remote.retrofit


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?
)