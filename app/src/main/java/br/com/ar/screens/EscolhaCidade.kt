package br.com.ar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EscolhaCidade(navController: NavController) {
    val entradaCidade = remember { mutableStateOf("") }

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
            label = { Text("Nome da cidade") }, // Adicione um rótulo para o campo
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White)
                .padding(horizontal = 16.dp)
        )

        // Card para informações sobre a qualidade do ar
        AirQualityCard()

        // Card para informações sobre a temperatura
        TemperatureCard()

        Button(
            onClick = { navController.navigate("start") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text(text = "Voltar", fontSize = 20.sp, color = Color.Blue)
        }
    }
}

@Composable
fun AirQualityCard() {
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
            text = "Boa", // Aqui você pode adicionar a informação real da qualidade do ar
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Composable
fun TemperatureCard() {
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
            text = "25°C", // Aqui você pode adicionar a informação real da temperatura
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}
