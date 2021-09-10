package com.example.carcamping.data.repo

import com.example.carcamping.api.response.GoCampingResponse
import com.example.carcamping.data.source.remote.GoCampingRemoteDataSource
import org.koin.java.KoinJavaComponent.inject

class GoCampingRepositoryImpl :
    GoCampingRepository {

    private val goCampingRemoteDataSource by inject<GoCampingRemoteDataSource>(GoCampingRepository::class.java)

    override fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getBasedList(onSuccess, onFailure)
    }

}