package br.com.ar.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.messias.weatherapi.model.WeatherResponse
import br.com.messias.weatherapi.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun EscolhaCidade(navController: NavController) {
    val entradaCidade = remember { mutableStateOf("") }

    var WeatherState by remember { mutableStateOf<WeatherResponse?>(null) }
    var AirState by remember { mutableStateOf<AirResponse?>(null) }

    // Chamando a função fetchAir sempre que WeatherState é atualizado
    LaunchedEffect(WeatherState) {
        WeatherState?.let { weather ->
            fetchAir(weather.coord.lat, weather.coord.lon) { response -> AirState = response }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14CCED))
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Digite o nome da cidade:",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )

        TextField(
            value = entradaCidade.value,
            onValueChange = { entradaCidade.value = it },
            label = { Text("Nome da cidade") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
                .padding(horizontal = 16.dp)
        )

        weatherState?.let { weather ->

            AirQualityCard(weather = weather)

            TemperatureCard(weather = weather)
        }

        Button(
            onClick = { navController.navigate("start") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text(text = "Voltar", fontSize = 20.sp, color = Color.Blue)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { fetchWeather(cityState) { response -> WeatherState = response } }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            }
        }
    }
}

@Composable
fun AirQualityCard(weather: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Qualidade do Ar:",
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = "AQUI: ${"201.94"}", // Aqui você pode adicionar a informação real da qualidade do ar
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Composable
fun TemperatureCard(weather: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Temperatura:",
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = "Temp: ${weather.main.temp}", // Aqui você pode adicionar a informação real da temperatura
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

// Função lambda que aceita uma função de retorno de chamada como argumento
fun fetchWeather(cityState: String, callback: (WeatherResponse) -> Unit) {
    val call = RetrofitFactory().getWeatherService().getWeather(city = cityState)

    call.enqueue(object : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            if (response.isSuccessful) {
                response.body()?.let { callback(it) }
            } else {
                Log.e("API Error", "Erro na resposta: ${response.body()}")
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            Log.e("API Error", "Falha na requisição: ${t.message}", t)
        }
    })
}

// Função lambda que aceita uma função de retorno de chamada como argumento e recebe lat e lon como parâmetros adicionais
fun fetchAir(lat: Double, lon: Double, callback: (AirResponse) -> Unit) {
    val call = RetrofitFactory().getWeatherService().getAir(lat = lat, lon = lon)

    call.enqueue(object : Callback<AirResponse> {
        override fun onResponse(call: Call<AirResponse>, response: Response<AirResponse>) {
            if (response.isSuccessful) {
                response.body()?.let { callback(it) }
            } else {
                Log.e("API Error", "Erro na resposta: ${response.body()}")
            }
        }

        override fun onFailure(call: Call<AirResponse>, t: Throwable) {
            Log.e("API Error", "Falha na requisição: ${t.message}", t)
        }
    })
}
