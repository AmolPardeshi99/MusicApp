package com.example.unit4_codingeval_2.model.remote.model


import com.google.gson.annotations.SerializedName

data class Crust(
    @SerializedName("defaultSize")
    val defaultSize: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sizes")
    val sizes: List<Size>?
)