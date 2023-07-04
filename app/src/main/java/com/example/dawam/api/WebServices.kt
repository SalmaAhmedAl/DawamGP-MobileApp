package com.example.dawam.api

import com.example.dawam.api.model.WaqfRequest
import com.example.dawam.api.model.waqfActivitiesResponse.WaqfActivitiesResponse
import com.example.dawam.api.model.waqfCitiesResponse.WaqfCitiesResponse
import com.example.dawam.api.model.waqfCountriesResponse.WaqfCountriesResponse
import com.example.dawam.api.model.waqfRequestResponse.WaqfRequestResponse
import com.example.dawam.api.model.waqfResponse.WaqfResponse
import com.example.dawam.api.model.waqfTypesResponse.WaqfTypesResponse
import com.example.dawam.api.model.wqfDetailsResponse.WaqfDetailsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WebServices {
    @GET("api/Waqf")
    fun getWaqf(): Call<ArrayList<WaqfResponse>>

    @GET("api/Waqf/{id}")
    fun getWaqfById(@Path(value ="id") id:Int): Call<WaqfDetailsResponse>

    @GET("api/Waqf/Types")
    fun getWaqfTypes(): Call<ArrayList<WaqfTypesResponse>>

    @GET("api/Waqf/Activities")
    fun getWaqfActivities(): Call<ArrayList<WaqfActivitiesResponse>>

    @GET("api/Country")
    fun getCountries(): Call<ArrayList<WaqfCountriesResponse>>

    @GET("api/City/{id}")
    fun getCities(@Path(value ="id") id:Int): Call<ArrayList<WaqfCitiesResponse>>

    @GET("/api/Waqf/Search/{search}")
    fun getSearch(@Path(value ="search") search:String): Call<ArrayList<WaqfResponse>>

    @POST("api/Waqf")
    fun sendWaqfRequest(@Body waqfRequest: WaqfRequest): Call<WaqfRequestResponse>
}