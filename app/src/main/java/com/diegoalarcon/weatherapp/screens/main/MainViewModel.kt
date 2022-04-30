package com.diegoalarcon.weatherapp.screens.main

import androidx.lifecycle.ViewModel
import com.diegoalarcon.weatherapp.data.DataOrException
import com.diegoalarcon.weatherapp.model.Weather
import com.diegoalarcon.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city)
    }
}