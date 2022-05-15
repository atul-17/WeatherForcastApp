package com.atul.apps10xsampleproject.utils

import com.atul.apps10xsampleproject.data.response.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: WeatherApiService = getRetrofit().create(WeatherApiService::class.java)
}