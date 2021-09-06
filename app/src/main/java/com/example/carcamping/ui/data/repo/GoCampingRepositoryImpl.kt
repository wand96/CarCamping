package com.example.carcamping.ui.data.repo

import com.example.carcamping.ui.api.response.GoCampingResponse
import com.example.carcamping.ui.data.source.remote.GoCampingRemoteDataSource

class GoCampingRepositoryImpl(private val goCampingRemoteDataSource: GoCampingRemoteDataSource) :
    GoCampingRepository {

    override fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getBasedList(onSuccess, onFailure)
    }
}