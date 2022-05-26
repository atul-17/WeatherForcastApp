package com.atul.apps10xsampleproject.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherForecastCacheEntity::class],version = 1)
    abstract class WeatherForecastDatabase : RoomDatabase() {
    abstract fun weatherForecastDao() :  WeatherForecastDao

    companion object{
        val DATABASE_NAME = "weather_db"
    }

}