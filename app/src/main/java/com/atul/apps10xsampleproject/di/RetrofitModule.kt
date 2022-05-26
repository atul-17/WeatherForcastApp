package com.atul.apps10xsampleproject.di

import com.atul.apps10xsampleproject.data.retrofit_response.WeatherApiService
import com.atul.apps10xsampleproject.utils.RetrofitBuilder
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//object keyword is used
// fo singleton instance
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson{
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    //    val apiService: WeatherApiService =
    //    getRetrofit().create(WeatherApiService::class.java)
    @Singleton
    @Provides
    fun provideWeatherApiService(retrofit: Retrofit.Builder) : WeatherApiService{
        return retrofit
            .build()
            .create(WeatherApiService::class.java)
    }

}