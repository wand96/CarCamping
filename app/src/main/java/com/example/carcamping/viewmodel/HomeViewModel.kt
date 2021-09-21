package com.example.carcamping.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carcamping.data.model.GoCampingItem
import com.example.carcamping.data.repo.GoCampingRepository
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel : ViewModel() {

    private val goCampingRepository by inject<GoCampingRepository>(GoCampingRepository::class.java)

    private val _homeViewStateLiveData = MutableLiveData<HomeViewState>()
    val homeViewStateLiveData: LiveData<HomeViewState> = _homeViewStateLiveData


    @SuppressLint("LongLogTag")
    fun getGoCampingBasedList() {

        goCampingRepository.getBasedList(
            onSuccess = {
                Log.d("결과-getGoCampingBasedList", it.response.header.resultCode)

                Log.d("결과-getGoCampingBasedList", it.response.body.basedListItems.item[0].sigunguNm)
                Log.d(
                    "결과-getGoCampingBasedList",
                    it.response.body.basedListItems.item[0].mapX.toString()
                )
                Log.d(
                    "결과-getGoCampingBasedList",
                    it.response.body.basedListItems.item[0].mapY.toString()
                )
            }, onFailure = {
                Log.d("결과-failure", it.message!!)
            }
        )
    }

    @SuppressLint("LongLogTag")
    fun getGoCampingLocationList(mapX: Double, mapY: Double, radius: Int) {
        goCampingRepository.getLocationList(mapX, mapY, radius,
            onSuccess = {
                Log.d("결과-getGoCampingLocationList-code", it.response.header.resultCode)
                Log.d("결과-getGoCampingLocationList-addr1", it.response.body.items.item[0].addr1)
                Log.d(
                    "결과-getGoCampingLocationList-addr2",
                    it.response.body.items.item[0].addr2 ?: "null"
                )
                Log.d(
                    "결과-getGoCampingLocationList-facltNm",
                    it.response.body.items.item[0].facltNm ?: ""
                )
            }, onFailure = {

            })

    }

    fun getSearchList(keyword: String) {

        goCampingRepository.getSearchList(keyword,
            onSuccess = {
                Log.d("결과-getSearchList", it.response.body.items.item[0].addr1 ?: "")
                Log.d("결과-getSearchList", it.response.body.items.item[0].tel ?: "")
                Log.d("결과-getSearchList", it.response.body.items.item[0].animalCmgCl ?: "")
            }, onFailure = {
                Log.d("결과-getSearchList", it.message ?: "")
            })

    }

    fun getImageList(contentId: String) {

        goCampingRepository.getImageList(contentId,
            onSuccess = {

                val urlList =
                    it.imageResponse.body.items.item.map { imageItem -> imageItem.imageUrl }

                urlList.forEach { url ->
                    Log.d("결과-getImageList", url)
                }

            }, onFailure = {
                Log.d("결과-getImageList", it.message ?: "")
            })
    }

    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}