package com.atul.apps10xsampleproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.atul.apps10xsampleproject.data.WeatherInfoRepo
import com.atul.apps10xsampleproject.utils.Resource
import kotlinx.coroutines.Dispatchers


class WeatherInfoViewModel(val weatherInfoRepo: WeatherInfoRepo) : ViewModel() {
    fun getWeatherData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherInfoRepo.getCurrentWeatherData()))
        }catch (exception:Exception){
            emit(Resource.error(data = null,message = exception.message?:"Something went wrong"))
        }
    }

    fun getForecastData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherInfoRepo.getForecastData()))
        }catch (ex:Exception){
            emit(Resource.error(data = null,message = ex.message?:"Something went wrong"))
        }
    }
}