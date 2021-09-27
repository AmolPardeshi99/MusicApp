package com.example.unit4_codingeval_2.model.remote.retrofit


import com.google.gson.annotations.SerializedName

data class PizzaResponseModel(
    @SerializedName("crusts")
    val crusts: List<Crust>?,
    @SerializedName("defaultCrust")
    val defaultCrust: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("isVeg")
    val isVeg: Boolean?,
    @SerializedName("name")
    val name: String?
)