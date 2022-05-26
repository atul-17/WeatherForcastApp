package com.atul.apps10xsampleproject.utils

import android.util.Log
import com.atul.apps10xsampleproject.data.ModelWeekyForecastData
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastDataEntity
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastList
import com.atul.apps10xsampleproject.room.WeatherForecastCacheEntity
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Inject


class CacheMapper
@Inject
constructor() : EntityMapper<WeatherForecastCacheEntity,ModelWeekyForecastData> {
    override fun mapFromEntity(entity: WeatherForecastCacheEntity): ModelWeekyForecastData? {
        return ModelWeekyForecastData(
            id = entity.id,
            dayofTheWeek = entity.dayofTheWeek,
            temp = entity.temp
        )
    }

    override fun mapToDomainModel(domainModel: ModelWeekyForecastData): WeatherForecastCacheEntity {
       return WeatherForecastCacheEntity(
           id = domainModel.id,
           dayofTheWeek = domainModel.dayofTheWeek,
           temp = domainModel.temp
       )
    }

    fun mapEntriesToList(entiesList:List<WeatherForecastCacheEntity>) : List<ModelWeekyForecastData>{
       return entiesList.map { mapFromEntity(it)!! }
    }
}
