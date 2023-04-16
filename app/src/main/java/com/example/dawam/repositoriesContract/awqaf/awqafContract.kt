package com.example.dawam.repositoriesContract.awqaf

import com.example.dawam.api.model.waqfRespons.Response
import com.example.dawam.api.model.waqfRespons.ResponseItem

interface AwqafRepository {
    suspend fun getAwqaf(): String?
}
interface AwqafRemoteDataSource {
    suspend fun getAwqaf(): String?
}