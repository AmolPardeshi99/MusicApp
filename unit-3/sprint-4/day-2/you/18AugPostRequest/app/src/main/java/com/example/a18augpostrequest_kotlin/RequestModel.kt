package com.example.a18augpostrequest_kotlin

import com.google.gson.annotations.SerializedName

data class RequestModel(
	@SerializedName("email")
	var email: String,
	@SerializedName("password")
	var password: String,
	@SerializedName("requestType")
	var requestType: String,
	@SerializedName("title")
	var title: String
)