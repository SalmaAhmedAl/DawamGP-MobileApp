package com.example.dawam.api

import com.example.dawam.api.model.waqfResponse.WaqfResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
    @GET("api/Waqf")
    fun getWaqf(): Call<ArrayList<WaqfResponse>>
}