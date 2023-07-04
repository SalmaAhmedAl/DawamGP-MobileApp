package com.example.dawam.api.model.waqfRequest

import com.google.gson.annotations.SerializedName

data class WaqfRequest(
    @field:SerializedName("WaqfName") var WaqfName:String,
    @field:SerializedName("FounderName") var FounderName:String,
    @field:SerializedName("DocumentNumber") var DocumentNumber:Int,
    @field:SerializedName("EstablishmentDate") var EstablishmentDate : String,
    @field:SerializedName("EstablishmentDateH")  var EstablishmentDateH : String,
    @field:SerializedName("WaqfDescription") var WaqfDescription:String,
    @field:SerializedName("WaqfCountryId") var WaqfCountryId:Int,
    @field:SerializedName("WaqfCityId") var WaqfCityId:Int,
    @field:SerializedName("WaqfTypeId") var WaqfTypeId:Int,
    @field:SerializedName("WaqfActivityId") var WaqfActivityId:Int,
    @field:SerializedName("WaqfImage") var WaqfImage:String,
    @field:SerializedName("WaqfDocument") var WaqfDocument:String,
    @field:SerializedName("InsUserId") var InsUserId:Int,
)
