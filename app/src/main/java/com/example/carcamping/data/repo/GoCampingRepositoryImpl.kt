package com.example.carcamping.data.repo

import com.example.carcamping.api.response.BasedListResponse
import com.example.carcamping.api.response.LocationBasedListResponse
import com.example.carcamping.api.response.SearchListResponse
import com.example.carcamping.data.source.remote.GoCampingRemoteDataSource
import org.koin.java.KoinJavaComponent.inject

class GoCampingRepositoryImpl :
    GoCampingRepository {

    private val goCampingRemoteDataSource by inject<GoCampingRemoteDataSource>(
        GoCampingRemoteDataSource::class.java
    )

    override fun getBasedList(
        onSuccess: (basedListResponse: BasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getBasedList(onSuccess, onFailure)
    }

    override fun getLocationList(
        mapX: Double,
        mapY: Double,
        radius: Int,
        onSuccess: (locationBasedListResponse: LocationBasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getLocationList(mapX, mapY, radius, onSuccess, onFailure)
    }

    override fun getSearchList(
        keyword: String,
        onSuccess: (searchListResponse: SearchListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getSearchList(keyword, onSuccess, onFailure)
    }

    override fun getImageList(
        contentId: String,
        onSuccess: (ImageListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingRemoteDataSource.getSearchList(contentId, onSuccess, onFailure)
    }
}