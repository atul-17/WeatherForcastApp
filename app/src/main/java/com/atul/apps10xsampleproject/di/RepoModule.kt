package com.atul.apps10xsampleproject.di

import com.atul.apps10xsampleproject.data.WeatherInfoRepo
import com.atul.apps10xsampleproject.data.retrofit_response.WeatherApiService
import com.atul.apps10xsampleproject.room.WeatherForecastDao
import com.atul.apps10xsampleproject.utils.CacheMapper
import com.atul.apps10xsampleproject.utils.NetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class )
@Module
object RepoModule {
    @Singleton
    @Provides
    fun provideWeatherInfoRepo(
        weatherForecastDao: WeatherForecastDao,
        weatherApiService: WeatherApiService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): WeatherInfoRepo {
        return WeatherInfoRepo(
            weatherForecastDao, weatherApiService, cacheMapper,
            networkMapper
        )
    }
}
