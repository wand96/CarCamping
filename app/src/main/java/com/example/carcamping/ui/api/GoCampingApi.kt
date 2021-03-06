package com.example.carcamping.ui.api

import com.example.carcamping.ui.api.response.GoCampingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingApi {

    companion object {
        private const val GO_CAMPING_KEY =
            "yPTjR42Wl6N%2FIFgWg0eMRf00dJ6fxMTOe3h4CEW%2F4GErO9W8gsC%2F46FtXCDFFDyPTrCxhDnDixF703uCHN8NZw%3D%3D"

        private const val MOBILE_OS = "AND"

        private const val MOBILE_APP = "CarCamping"

        private const val BASEDLIST_URL = "basedList"

        private const val TYPE_JSON = "json"
    }

    @GET(BASEDLIST_URL)
    fun getBasedList(
        @Query("ServiceKey") serviceKey: String = GO_CAMPING_KEY,
        @Query("MobileOS") mobileOS: String = MOBILE_OS,
        @Query("MobileApp") MobileApp: String = MOBILE_APP,
        @Query("_type") _type: String = TYPE_JSON
    ): Call<GoCampingResponse>

}