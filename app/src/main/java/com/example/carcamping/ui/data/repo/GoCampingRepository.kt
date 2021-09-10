package com.example.carcamping.ui.data.repo

import com.example.carcamping.ui.api.response.GoCampingResponse

interface GoCampingRepository {

    fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )
}