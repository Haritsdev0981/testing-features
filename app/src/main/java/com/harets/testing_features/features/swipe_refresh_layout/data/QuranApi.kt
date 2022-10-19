package com.harets.testing_features.features.swipe_refresh_layout.data

import com.harets.testing_features.features.swipe_refresh_layout.DataItem
import com.harets.testing_features.features.swipe_refresh_layout.SurahResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.alquran.cloud/v1/"

interface SurahApi {
    @GET("surah")
    fun getSurah() : Call<SurahResponse>

    companion object {
        operator fun invoke() : SurahApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SurahApi::class.java)
        }
    }
}