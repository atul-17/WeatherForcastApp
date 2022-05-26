package com.atul.apps10xsampleproject.data

import com.atul.apps10xsampleproject.data.retrofit_response.WeatherApiService

class ApiHelper(val weatherApiService: WeatherApiService) {
     val API_KEY = "50db7a4d6a73f18bceb98e1686b5c9c2"
    suspend fun getWeatherData() = weatherApiService.getWeatherData("Bengaluru",API_KEY)

    suspend fun getForecastData() = weatherApiService.getForecastData("Bengaluru",API_KEY)

}