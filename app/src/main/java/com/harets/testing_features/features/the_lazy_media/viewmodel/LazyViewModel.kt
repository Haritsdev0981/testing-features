package com.harets.testing_features.features.the_lazy_media.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harets.testing_features.features.the_lazy_media.remote.APIConfig
import com.harets.testing_features.features.the_lazy_media.response.LazyResponseItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LazyViewModel : ViewModel() {

    private val _lazyResponse = MutableLiveData<List<LazyResponseItem>>()
    val lazyResponse: LiveData<List<LazyResponseItem>> = _lazyResponse


    fun games() {
        APIConfig().getAPIService().getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _lazyResponse.value = it
            }, {
                Log.e("LazyViewModel", "$it")
            })
    }
}