package com.example.carcamping.data.source.remote

import com.example.carcamping.api.response.BasedListResponse
import com.example.carcamping.api.response.LocationBasedListResponse
import com.example.carcamping.api.response.SearchListResponse

interface GoCampingRemoteDataSource {

    fun getBasedList(
        onSuccess: (basedListResponse: BasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

    fun getLocationList(
        mapX: Double,
        mapY: Double,
        radius: Int,
        onSuccess: (locationBasedListResponse: LocationBasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

    fun getSearchList(
        keyword : String,
        onSuccess: (searchListResponse: SearchListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

    fun getImageList(
        conetentId : String,
        onSuccess: (imageListResponse: ImageListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )
}