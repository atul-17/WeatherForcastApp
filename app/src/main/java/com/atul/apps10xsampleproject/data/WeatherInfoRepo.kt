package com.atul.apps10xsampleproject.data

import androidx.lifecycle.MutableLiveData
import com.atul.apps10xsampleproject.data.response.CurrentTempApiModel
import com.atul.apps10xsampleproject.data.response.WeatherApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class WeatherInfoRepo(val apiHelper: ApiHelper) {
    suspend fun getCurrentWeatherData() = apiHelper.getWeatherData()

    suspend fun getForecastData() = apiHelper.getForecastData()


}