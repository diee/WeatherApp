package com.diegoalarcon.weatherapp.repository

import com.diegoalarcon.weatherapp.data.DataOrException
import com.diegoalarcon.weatherapp.model.Weather
import com.diegoalarcon.weatherapp.network.WeatherApi
import java.lang.Exception
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String):
            DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }
}