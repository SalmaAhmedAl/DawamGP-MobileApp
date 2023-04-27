package com.example.dawam.api.model.waqfResponse

import com.google.gson.annotations.SerializedName

data class WaqfResponse(
    @field:SerializedName("id") var id:Int,
    @field:SerializedName("waqfName") var waqfName:String,
    @field:SerializedName("founderName") var founderName:String,
    @field:SerializedName("establishmentDate") var establishmentDate : String,
    @field:SerializedName("establishmentDateH")  var establishmentDateH : String,
    @field:SerializedName("waqfDescription") var waqfDescription:String,
    @field:SerializedName("waqfCountry") var waqfCountry:String,
    @field:SerializedName("waqfCity") var waqfCity:String,
    @field:SerializedName("waqfType") var waqfType:String,
    @field:SerializedName("waqfActivity") var waqfActivity:String,
    @field:SerializedName("documentUrl") var documentUrl:String,
    )

