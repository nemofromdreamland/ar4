package br.com.ar.model

data class AirCoord(
    val lon: Double,
    val lat: Double
)

data class AirMain(
    val aqi: Int
)

data class Components(
    val co: Double,
    val no: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2_5: Double,
    val pm10: Double,
    val nh3: Double
)

data class AirResponse(
    val coord: AirCoord,
    val list: List<WeatherData>
)

data class WeatherData(
    val main: AirMain,
    val components: Components,
    val dt: Long
)