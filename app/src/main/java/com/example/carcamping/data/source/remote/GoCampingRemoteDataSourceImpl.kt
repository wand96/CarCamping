package com.example.carcamping.data.source.remote

import com.example.carcamping.api.GoCampingApi
import com.example.carcamping.api.response.BasedListResponse
import com.example.carcamping.api.response.LocationBasedListResponse
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoCampingRemoteDataSourceImpl :
    GoCampingRemoteDataSource {

    private val goCampingApi by inject<GoCampingApi>(GoCampingApi::class.java)

    override fun getBasedList(
        onSuccess: (basedListResponse: BasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingApi.getBasedList().enqueue(object : Callback<BasedListResponse> {
            override fun onResponse(
                call: Call<BasedListResponse>,
                response: Response<BasedListResponse>
            ) {
                response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<BasedListResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    override fun getLocationList(
        mapX: Double,
        mapY: Double,
        radius: Int,
        onSuccess: (locationBasedListResponse: LocationBasedListResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingApi.getLocationList(mapX, mapY, radius)
            .enqueue(object : Callback<LocationBasedListResponse> {
                override fun onResponse(
                    call: Call<LocationBasedListResponse>,
                    response: Response<LocationBasedListResponse>
                ) {
                    response.body()?.let(onSuccess)
                }

                override fun onFailure(call: Call<LocationBasedListResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }
}