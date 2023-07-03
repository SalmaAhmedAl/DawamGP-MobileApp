package com.example.dawam.api.model.waqfCountriesResponse

import com.google.gson.annotations.SerializedName

data class WaqfCountriesResponse(
    @field:SerializedName("name") var countryName:String,
    @field:SerializedName("id") var id:Int,
)
