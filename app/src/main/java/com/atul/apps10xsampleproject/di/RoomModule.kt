package com.atul.apps10xsampleproject.di

import android.content.Context
import androidx.room.Room
import com.atul.apps10xsampleproject.room.WeatherForecastDao
import com.atul.apps10xsampleproject.room.WeatherForecastDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideWeatherForecastDB(@ApplicationContext context: Context) : WeatherForecastDatabase{
        return Room.databaseBuilder(
            context,
            WeatherForecastDatabase::class.java,
            WeatherForecastDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherForecastDAO(weatherForecastDatabase: WeatherForecastDatabase) : WeatherForecastDao{
        return weatherForecastDatabase.weatherForecastDao()
    }

}