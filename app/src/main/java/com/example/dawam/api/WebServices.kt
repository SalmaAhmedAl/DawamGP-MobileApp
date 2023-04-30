package com.example.dawam.api

import com.example.dawam.api.model.waqfResponse.WaqfResponse
import com.example.dawam.api.model.wqfDetailsResponse.WaqfDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {
    @GET("api/Waqf")
    fun getWaqf(): Call<ArrayList<WaqfResponse>>

    @GET("api/Waqf/{id}")
    fun getWaqfById(@Path(value ="id") id:Int): Call<WaqfDetailsResponse>
}