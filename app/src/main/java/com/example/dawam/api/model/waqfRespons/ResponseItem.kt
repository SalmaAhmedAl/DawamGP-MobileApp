package com.example.dawam.api.model.waqfRespons

import com.google.gson.annotations.SerializedName
//waqf details
data class ResponseItem(

	@field:SerializedName("adminNotes")
	val adminNotes: Any? = null,

	@field:SerializedName("insDate")
	val insDate: String? = null,

	@field:SerializedName("establishmentDate")
	val establishmentDate: String? = null,

	@field:SerializedName("documentNumber")
	val documentNumber: Int? = null,

	@field:SerializedName("documentUrl")
	val documentUrl: String? = null,

	@field:SerializedName("waqfCountry")
	val waqfCountry: String? = null,

	@field:SerializedName("founderName")
	val founderName: String? = null,

	@field:SerializedName("confirmUser")
	val confirmUser: Any? = null,

	@field:SerializedName("confirmUserId")
	val confirmUserId: Any? = null,

	@field:SerializedName("confirmDate")
	val confirmDate: Any? = null,

	@field:SerializedName("waqfCity")
	val waqfCity: String? = null,

	@field:SerializedName("waqfName")
	val waqfName: String? = null,

	@field:SerializedName("waqfStatus")
	val waqfStatus: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: Any? = null,

	@field:SerializedName("establishmentDateH")
	val establishmentDateH: String? = null,

	@field:SerializedName("waqfType")
	val waqfType: String? = null,

	@field:SerializedName("waqfDescription")
	val waqfDescription: String? = null,

	@field:SerializedName("insUser")
	val insUser: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("insUserId")
	val insUserId: Int? = null,

	@field:SerializedName("waqfActivity")
	val waqfActivity: String? = null
)