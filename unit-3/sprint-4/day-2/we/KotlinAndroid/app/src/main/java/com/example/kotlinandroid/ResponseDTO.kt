package com.example.kotlinandroid

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDTO(

	@field:SerializedName("name")
	val name: String? = null,



	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)