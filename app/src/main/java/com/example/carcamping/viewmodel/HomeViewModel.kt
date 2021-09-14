package com.example.carcamping.viewmodel

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


    fun getGoCampingBasedList() {

        goCampingRepository.getBasedList(
            onSuccess = {
                Log.d("결과-success", it.response.header.resultCode)
                Log.d("결과-success", it.response.body.basedListItems.item.size.toString())
            }, onFailure = {
                Log.d("결과-failure", it.message!!)
            }
        )
    }

    fun getGoCampingLocationList(mapX: Double, mapY: Double, radius: Int) {
        goCampingRepository.getLocationList(mapX, mapY, radius,
            onSuccess = {
                Log.d("결과성공-code", it.response.header.resultCode)
                Log.d("결과성공-addr1", it.response.body.items.item[0].addr1)
                Log.d("결과성공-addr2", it.response.body.items.item[0].addr2 ?: "null")
                Log.d("결과성공-facltNm", it.response.body.items.item[0].facltNm ?: "")
            }, onFailure = {

            })

    }

    fun getSearchList(keyword : String) {

        goCampingRepository.getSearchList(keyword,onSuccess = {},onFailure = {})

    }


    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}