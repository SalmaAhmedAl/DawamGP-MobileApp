package com.example.dawam.api.model.waqfCitiesResponse

import com.google.gson.annotations.SerializedName

data class WaqfCitiesResponse(
    @field:SerializedName("name") var cityName:String,
    @field:SerializedName("id") var id:Int,
)
