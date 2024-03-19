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
            // PRIMEIRA PARTE
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
            Spacer(modifier = Modifier.height(16.dp)) //espaço entre as Surfaces
            // FIM PRIMEIRA PARTE
            // SEGUNDA PARTE INICIO

            Button(
                onClick = { navController.navigate("aprenda")  },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "IMPORTÂNCIA DE MEDIR A QUALIDADE DO AR",
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
                        text = "Medimos a qualidade do ar para entender os níveis de poluição atmosférica em uma determinada área.",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Isso nos ajuda a identificar fontes de poluentes, avaliar riscos para a saúde pública e tomar medidas para reduzir a poluição e proteger a saúde das pessoas e o meio ambiente.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )
                    Text(
                        text = "A medição da qualidade do ar é essencial para garantir um ambiente saudável e sustentável para todos.",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                }
            }
            Spacer(modifier = Modifier.height(16.dp)) //espaço entre as Surfaces
            // FIM SEGUNDA PARTE
            // TERCEIRA PARTE INICIO

            Button(
                onClick = { navController.navigate("aprenda")  },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "COMO MONITORAR A QUALIDADE DO AR?",
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
                        text = "Monitoramento Direto: ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text ="Equipamentos específicos para medir a concentração de poluentes no ar ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )
                    Text(
                        text = "Monitoramento Remoto: ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Satélites e drones para monitoraram a qualidade do ar em áreas extensas ou de difícil acesso.",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Modelagem Computacional: ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text ="Modelos matemáticos para simulam a dispersão de poluentes na atmosfera e fazem a previsão da qualidade do ar em determinadas áreas.",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )

                    Text(
                        text = "O Índice de Qualidade do Ar (AQI - Air Quality Index) é uma medida padronizada que quantifica a qualidade do ar com base na concentração de poluentes atmosféricos. ",
                        fontSize = 18.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp)) //espaço entre as Surfaces

            // Botão de voltar
            Button(
                onClick = { navController.navigate("start") },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(text = "Voltar", fontSize = 20.sp, color = Color.Blue)
            }
            // Adicionando a animação das nuvens no final da tela
            AnimatedClouds()
        }
    }
}