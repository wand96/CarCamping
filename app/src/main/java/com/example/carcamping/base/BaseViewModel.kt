package com.example.carcamping.base

import android.app.Application
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    private val _viewStateLiveData = MutableLiveData<ViewState>()
    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData

    protected fun viewStateChanged(viewState: ViewState) {
        _viewStateLiveData.value = viewState
        _viewStateLiveData.value = null
    }
}