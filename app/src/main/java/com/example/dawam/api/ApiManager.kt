package com.example.dawam.api

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object {
        private var retrofit: Retrofit? = null;

        @Synchronized
        private fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://afdinc-001-site5.itempurl.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!;
        }

        fun getApis(): WebServices {
            return getInstance().create(WebServices::class.java);
        }

    }



}


