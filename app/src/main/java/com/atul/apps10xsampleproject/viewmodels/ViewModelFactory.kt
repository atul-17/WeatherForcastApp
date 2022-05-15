package com.atul.apps10xsampleproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atul.apps10xsampleproject.data.ApiHelper
import com.atul.apps10xsampleproject.data.WeatherInfoRepo
import java.lang.IllegalStateException

class ViewModelFactory(val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WeatherInfoViewModel::class.java)){
            return WeatherInfoViewModel(WeatherInfoRepo(apiHelper)) as T
        }
        throw IllegalStateException("Unknown class name")
    }
}