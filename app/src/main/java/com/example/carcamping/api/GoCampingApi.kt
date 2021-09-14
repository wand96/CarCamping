package com.example.carcamping.api

import com.example.carcamping.api.response.BasedListResponse
import com.example.carcamping.api.response.LocationBasedListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GoCampingApi {

    companion object {
        private const val GO_CAMPING_KEY =
            "yPTjR42Wl6N%2FIFgWg0eMRf00dJ6fxMTOe3h4CEW%2F4GErO9W8gsC%2F46FtXCDFFDyPTrCxhDnDixF703uCHN8NZw%3D%3D"

        private const val MOBILE_OS = "AND"

        private const val MOBILE_APP = "CarCamping"

        private const val BASE_URL = "ServiceKey=$GO_CAMPING_KEY&MobileOS=$MOBILE_OS&MobileApp=$MOBILE_APP\""

        private const val BASEDLIST_URL =
            "basedList?ServiceKey=$GO_CAMPING_KEY&MobileOS=$MOBILE_OS&MobileApp=$MOBILE_APP"

        private const val LOCATION_LIST_URL =
            "locationBasedList?ServiceKey=$GO_CAMPING_KEY&MobileOS=$MOBILE_OS&MobileApp=$MOBILE_APP"

        private const val TYPE_JSON = "json"
    }

    @GET(BASEDLIST_URL)
    fun getBasedList(
        @Query(value = "_type") type: String = TYPE_JSON
    ): Call<BasedListResponse>


    @GET(LOCATION_LIST_URL)
    fun getLocationList(
        @Query(value = "mapX") mapX: Double,
        @Query(value = "mapY") mapY: Double,
        @Query(value = "radius") radius: Int,
        @Query(value = "_type") type: String = TYPE_JSON
    ): Call<LocationBasedListResponse>


}