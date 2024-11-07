package com.example.weatherchallengeapp.api

import com.example.weatherchallengeapp.api.data.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getWeather(@Query("q") city: String, @Query("appid") apikey: String): Response<WeatherModel>
}