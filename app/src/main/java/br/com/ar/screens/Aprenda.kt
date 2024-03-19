package br.com.ar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun Aprenda(navController: NavController) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14CCED))
            .padding(32.dp)
            .verticalScroll(state = scrollState)
    ) {
        // Adicionar a animação das nuvens antes do conteúdo da tela de aprendizado
        AnimatedClouds(
            modifier = Modifier.fillMaxSize()
        )

        // Conteúdo da tela de aprendizado
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "A qualidade do ar é essencial para a saúde e o bem-estar humano!",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = { navController.navigate("aprenda")  },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "TIPOS DE POLUENTES DO AR",
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "O ar pode ser poluído por diversos tipos de substâncias, incluindo: ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )

                    Text(
                        text = "Dióxido de carbono (CO2), dióxido de enxofre (SO2), ozônio (O3) e partículas finas (PM2.5)",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Esses poluentes podem ter diversos efeitos negativos na saúde humana, como doenças respiratórias e cardiovasculares, além de causar danos ao meio ambiente, como a acidificação dos solos e a destruição da camada de ozônio.",
                        fontSize = 18.sp,
                        color = Color.Blue
                    )
                }
            }

            // Botão de voltar adicionado abaixo do card
            Button(
                onClick = { navController.navigate("start") },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            ) {
                Text(text = "Voltar", fontSize = 20.sp, color = Color.Blue)
            }
        }
    }
}


