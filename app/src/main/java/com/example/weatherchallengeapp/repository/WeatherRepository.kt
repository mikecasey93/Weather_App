package com.example.weatherchallengeapp.repository

import com.example.weatherchallengeapp.api.WeatherApi
import com.example.weatherchallengeapp.api.data.WeatherModel
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(city: String, apiKey: String): WeatherModel {
        val response = api.getWeather(city = city, apikey = apiKey)
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("No data found")
        } else {
            throw Exception("Error fetching details")
        }
    }
}