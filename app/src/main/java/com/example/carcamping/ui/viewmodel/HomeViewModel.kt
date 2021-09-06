package com.example.carcamping.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carcamping.ui.data.model.GoCampingItem

class HomeViewModel : ViewModel() {

    private val _homeViewStateLiveData = MutableLiveData<HomeViewState>()
    val homeViewStateLiveData : LiveData<HomeViewState> = _homeViewStateLiveData


    fun getGoCampingBasedList() {


    }



    sealed class HomeViewState {
        data class GetGoCampingBasedList(val goCampingItem: GoCampingItem) : HomeViewState()
        object ErrorGetGoCampingBasedList : HomeViewState()
    }

}