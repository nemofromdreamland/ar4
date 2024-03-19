package br.com.messias.weatherapi.service

import br.com.ar.service.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "https://api.openweathermap.org/data/2.5/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getWeatherService(): WeatherService {
        return retrofitFactory.create(WeatherService::class.java)
    }
}