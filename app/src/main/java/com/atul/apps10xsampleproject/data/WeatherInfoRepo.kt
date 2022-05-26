package com.atul.apps10xsampleproject.data

import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastDataEntity
import com.atul.apps10xsampleproject.data.retrofit_response.WeatherApiService
import com.atul.apps10xsampleproject.room.WeatherForecastCacheEntity
import com.atul.apps10xsampleproject.room.WeatherForecastDao
import com.atul.apps10xsampleproject.utils.CacheMapper
import com.atul.apps10xsampleproject.utils.DataState
import com.atul.apps10xsampleproject.utils.NetworkMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherInfoRepo
constructor(val weatherForecastDao: WeatherForecastDao?,
            val weatherApiService: WeatherApiService,
            val cacheMapper:  CacheMapper,
            val networkMapper: NetworkMapper) {
    //suspend fun getCurrentWeatherData() = apiHelper.getWeatherData()
//
//    suspend fun getForecastData() = apiHelper.getForecastData()

    val API_KEY = "50db7a4d6a73f18bceb98e1686b5c9c2"

    suspend fun getForecastData():
            Flow<DataState<ModelForecastDataEntity>> = flow {
                    emit(DataState.Loading)
                    try {
                        val modelForecastDataEntities = weatherApiService.getForecastData("Bengaluru",API_KEY)
                        val forecastDataList = networkMapper.mapFromEntityList(modelForecastDataEntities.list
                                as List<ModelForecastDataEntity>)

                        for (forecastData in forecastDataList){
                            weatherForecastDao?.insert(cacheMapper.mapToDomainModel(forecastData))
                        }
                    }catch (e:Exception){
                            emit(DataState.Error(e) )
                    }
            }

}


