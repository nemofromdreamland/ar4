package br.com.ar.service

import br.com.ar.model.WeatherResponse

import br.com.ar.model.AirResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather?appid=ac0fcb09923c7659a418007c763bc0d7&units=metric&lang=pt_br")
    fun getWeather(
        @Query("q") city: String
    ): Call<WeatherResponse>

    @GET("air_pollution?appid=ac0fcb09923c7659a418007c763bc0d7&units=metric&lang=pt_br")
    fun getAir(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): Call<AirResponse>
}