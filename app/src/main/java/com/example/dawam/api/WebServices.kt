package com.example.dawam.api

import com.example.dawam.api.model.waqfRespons.ResponseItem
import retrofit2.http.GET

interface WebServices {
    @GET("api/Waqf")
    suspend fun getWaqf(
    ): ResponseItem
}