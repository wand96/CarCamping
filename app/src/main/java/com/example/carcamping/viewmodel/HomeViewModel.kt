package com.example.carcamping.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carcamping.api.response.LocationItem
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

            }, onFailure = {

            }
        )
    }


    fun getGoCampingLocationList(longitude: Double, latitude: Double, radius: Int) {
        goCampingRepository.getLocationList(longitude, latitude, radius,
            onSuccess = {
                _homeViewStateLiveData.value =
                    HomeViewState.GetGoCampingLocationList(it.response.body.items.item)
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
                it.imageResponse.body.items.item.map {imageItem -> imageItem.imageUrl }
        }, onFailure = {

            })
    }

    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        data class GetGoCampingLocationList(val itemList: List<LocationItem>) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}