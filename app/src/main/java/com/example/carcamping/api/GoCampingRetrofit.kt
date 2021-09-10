package com.example.carcamping.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GoCampingRetrofit {


    private const val GO_CAMPING_BASE_URL =
        "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/"

    fun create(): GoCampingApi =
        Retrofit.Builder()
            .baseUrl(GO_CAMPING_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoCampingApi::class.java)

}