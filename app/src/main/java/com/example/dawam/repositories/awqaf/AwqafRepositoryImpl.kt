package com.example.dawam.repositories.awqaf

import com.example.dawam.repositoriesContract.awqaf.AwqafRemoteDataSource
import com.example.dawam.repositoriesContract.awqaf.AwqafRepository

class AwqafRepositoryImpl(val data: AwqafRemoteDataSource): AwqafRepository {
    override suspend fun getAwqaf(): String? {
        val awqaf = data.getAwqaf()
        return awqaf
    }
}