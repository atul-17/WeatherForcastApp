package com.atul.apps10xsampleproject.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weekly_forecast_data")
data class WeatherForecastCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "day_of_the_week")
    var dayofTheWeek:String?,

    @ColumnInfo(name = "avg_temp")
    var temp:String

    ) {}