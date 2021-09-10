package com.example.carcamping.data.repo

import com.example.carcamping.api.response.GoCampingResponse

interface GoCampingRepository {

    fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )
}