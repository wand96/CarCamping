package com.example.carcamping.data.source.remote

import com.example.carcamping.api.GoCampingApi
import com.example.carcamping.api.response.GoCampingResponse
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoCampingRemoteDataSourceImpl :
    GoCampingRemoteDataSource {

    private val goCampingApi by inject<GoCampingApi>(GoCampingApi::class.java)

    override fun getBasedList(
        onSuccess: (goCampingResponse: GoCampingResponse) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        goCampingApi.getBasedList().enqueue(object : Callback<GoCampingResponse> {
            override fun onResponse(
                call: Call<GoCampingResponse>,
                response: Response<GoCampingResponse>
            ) {
                response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<GoCampingResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}