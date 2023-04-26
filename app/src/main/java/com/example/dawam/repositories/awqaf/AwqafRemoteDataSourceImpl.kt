package com.example.dawam.repositories.awqaf

import com.example.dawam.api.WebServices
import com.example.dawam.api.model.waqfRespons.Response
import com.example.dawam.api.model.waqfRespons.ResponseItem
import com.example.dawam.repositoriesContract.awqaf.AwqafRemoteDataSource

class AwqafRemoteDataSourceImpl(val webServices:WebServices): AwqafRemoteDataSource {
    override suspend fun getAwqaf(): String?{
        val response = webServices.getWaqf()
        return response.waqfDescription

    }
}