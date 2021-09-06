package com.example.carcamping.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carcamping.ui.data.model.GoCampingItem
import com.example.carcamping.ui.data.repo.GoCampingRepository

class HomeViewModel(private val goCampingRepository: GoCampingRepository) : ViewModel() {

    private val _homeViewStateLiveData = MutableLiveData<HomeViewState>()
    val homeViewStateLiveData: LiveData<HomeViewState> = _homeViewStateLiveData


    fun getGoCampingBasedList() {

        goCampingRepository.getBasedList(
            onSuccess = {
                Log.d("결과-success", it.response.header.resultCode)
                Log.d("결과-success", it.response.body.items.item.size.toString())
            }, onFailure = {
                Log.d("결과-failure", it.message!!)
            }
        )
    }


    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}