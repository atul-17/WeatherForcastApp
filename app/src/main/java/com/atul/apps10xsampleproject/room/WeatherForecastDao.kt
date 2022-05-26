package com.atul.apps10xsampleproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherForecastDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert(weatherForecastEntity : WeatherForecastCacheEntity) : Long

@Query("SELECT * FROM WEEKLY_FORECAST_DATA")
suspend fun get() : List<WeatherForecastCacheEntity>

}