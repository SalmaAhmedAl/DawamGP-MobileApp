package com.example.dawam.ui.home

import androidx.lifecycle.ViewModel
import com.example.dawam.api.ApiManager

class HomeViewModel: ViewModel() {

    suspend fun getAwqaf(){
        val serverData=
            ApiManager.
            getApis().getWaqf()

    }
}