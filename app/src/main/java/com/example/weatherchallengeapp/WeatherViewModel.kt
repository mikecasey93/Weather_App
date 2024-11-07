package com.example.weatherchallengeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherchallengeapp.api.Key
import com.example.weatherchallengeapp.api.data.WeatherModel
import com.example.weatherchallengeapp.repository.WeatherRepository
import com.example.weatherchallengeapp.state.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    private val _weatherData = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherData: LiveData<NetworkResponse<WeatherModel>> = _weatherData

    fun getCity(city: String) {
        _weatherData.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = repository.getWeather(city,Key.apiKey)
                _weatherData.postValue(NetworkResponse.Success(response))
            }
            catch (e: Exception) {
                _weatherData.postValue((NetworkResponse.Error(e.toString())))
            }
        }
    }
}