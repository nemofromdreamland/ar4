package br.com.messias.weatherapi.service

import androidx.compose.runtime.MutableState
import br.com.messias.weatherapi.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather?appid=ac0fcb09923c7659a418007c763bc0d7&units=metric&lang=pt_br")
    fun getWeather(
        @Query("q") city: MutableState<String>
    ): Call<WeatherResponse>
}