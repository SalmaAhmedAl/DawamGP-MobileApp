package com.example.dawam.api.model.waqfRespons

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Response")
	val response: List<ResponseItem?>? = null
)