package com.example.scopingfunction


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("support")
    val support: Support?
)