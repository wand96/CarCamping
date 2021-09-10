package com.example.carcamping.data.source.remote

import com.example.carcamping.ui.api.response.GoCampingResponse

interface GoCampingRemoteDataSource {

    fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

}