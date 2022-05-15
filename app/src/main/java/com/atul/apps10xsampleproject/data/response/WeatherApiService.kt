package com.atul.apps10xsampleproject.data.response

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.openweathermap.org/data/2.5/weather?q=Bengaluru&APPID=9b8cb8c7f11c077f8c4e217974d9ee40

//https://api.openweathermap.org/data/2.5/forecast?q=Bengaluru&APPID=9b8cb8c7f11c077f8c4e217974d9ee40

interface WeatherApiService {
    @GET("weather")
   suspend fun getWeatherData(@Query("q")location:String,@Query("APPID")apiKey: String) : CurrentTempApiModel
   @GET("forecast")
   suspend fun getForecastData(@Query("q")location: String,@Query("APPID")apiKey: String) : ModelForecastData

}
