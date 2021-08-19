package com.example.a18augpostrequest_kotlin

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ResponseModel : Serializable {
    @SerializedName("email")
    val email: String? = null

    @SerializedName("password")
    val password: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("requestType")
    val requestType: String? = null

    @SerializedName("id")
    val id = 0
}