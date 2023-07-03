package com.example.dawam.api.model.waqfActivitiesResponse
import com.google.gson.annotations.SerializedName

data class WaqfActivitiesResponse(
    @field:SerializedName("name") var waqfActivityName:String,
    @field:SerializedName("id") var id:Int,
)
