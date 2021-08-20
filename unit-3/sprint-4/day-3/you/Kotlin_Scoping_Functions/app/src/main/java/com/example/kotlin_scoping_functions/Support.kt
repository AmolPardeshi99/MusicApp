package com.example.kotlin_scoping_functions


import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("text")
    val text: String?,
    @SerializedName("url")
    val url: String?
)