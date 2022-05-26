package com.atul.apps10xsampleproject.data.retrofit_response

import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiService {
    @GET("weather")
   suspend fun getWeatherData(@Query("q")location:String,@Query("APPID")apiKey: String) : CurrentTempApiEntity
   @GET("forecast")
   suspend fun getForecastData(@Query("q")location: String,@Query("APPID")apiKey: String) : ModelForecastDataEntity

}
