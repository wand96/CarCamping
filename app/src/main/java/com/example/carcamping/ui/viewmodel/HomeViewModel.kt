package com.example.carcamping.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carcamping.api.response.LocationItem
import com.example.carcamping.base.BaseViewModel
import com.example.carcamping.ui.data.model.GoCampingItem
import com.example.carcamping.ui.data.repo.GoCampingRepository
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel(app: Application) : BaseViewModel(app) {

   private val goCampingRepository by inject<GoCampingRepository>(GoCampingRepository::class.java)

    fun getGoCampingBasedList() {

        goCampingRepository.getBasedList(
            onSuccess = {

            }, onFailure = {

            }
        )
    }

    fun getGoCampingLocationList(longitude: Double, latitude:Double, radius: Int) {
        goCampingRepository.getLocationList(longitude, latitude, radius,
            onSuccess = {
                viewStateChanged(HomeViewState.GetGoCampingLocationList(it.response.body.items.item))
            }, onFailure = {
                Log.d("결과 error", it.message.toString())
            })
    }

    fun getSearchList(keyword: String) {

        goCampingRepository.getSearchList(keyword,
            onSuccess = {

            }, onFailure = {

            })
    }

    fun getImageList(contentId: String) {
        goCampingRepository.getImageList(contentId,
            onSuccess = {
                val urlList =
                    it.imageResponse.body.items.item.map { imageItem -> imageItem.imageUrl}
            })
    }

    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        data class GetGoCampingLocationList(val itemList: List<LocationItem>) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}