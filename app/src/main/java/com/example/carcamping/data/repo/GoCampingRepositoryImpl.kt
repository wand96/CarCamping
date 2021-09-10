package com.example.carcamping.data.repo

import com.example.carcamping.ui.api.response.GoCampingResponse
import com.example.carcamping.data.source.remote.GoCampingRemoteDataSource

class GoCampingRepositoryImpl(private val goCampingRemoteDataSource: GoCampingRemoteDataSource) :
    GoCampingRepository {

    override fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getBasedList(onSuccess, onFailure)
    }


    companion object {

        private var instance: GoCampingRepositoryImpl? = null

        fun getInstance(goCampingRemoteDataSource: GoCampingRemoteDataSource): GoCampingRepository =
            instance ?: GoCampingRepositoryImpl(goCampingRemoteDataSource).also {
                instance = it
            }

    }

}