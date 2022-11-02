package com.harets.testing_features.features.the_lazy_media.remote

import com.harets.testing_features.features.the_lazy_media.response.LazyResponseItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET


interface APIService {

    @GET("games")
    fun getNews(): Flowable<List<LazyResponseItem>>
}