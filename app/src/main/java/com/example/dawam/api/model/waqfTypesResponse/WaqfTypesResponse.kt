package com.example.dawam.api.model.waqfTypesResponse

import com.google.gson.annotations.SerializedName

data class WaqfTypesResponse(
    @field:SerializedName("name") var typeName:String,
    @field:SerializedName("id") var id:Int,
)
