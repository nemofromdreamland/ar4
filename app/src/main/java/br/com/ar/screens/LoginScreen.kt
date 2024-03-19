package br.com.ar.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF14CCED))
            .padding(32.dp)
    ) {
        AnimatedClouds()

        // Conteúdo da tela de login
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Seja Bem-vindo ao AR-LIMPO!",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.navigate("escolha") },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "QUERO SABER COMO ESTÁ O AR DA MINHA CIDADE!",
                        fontSize = 20.sp,
                        color = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("aprenda") },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "QUERO APRENDER SOBRE POLUIÇÃO DO AR!",
                        fontSize = 20.sp,
                        color = Color.Blue
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedClouds() {
    val infiniteTransition = rememberInfiniteTransition()
    val cloud1XPosition by infiniteTransition.animateFloat(
        initialValue = 500f, // Iniciar da posição mais à direita
        targetValue = -500f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val cloud2XPosition by infiniteTransition.animateFloat(
        initialValue = 600f, // Iniciar da posição mais à direita
        targetValue = -500f,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val cloud3XPosition by infiniteTransition.animateFloat(
        initialValue = 700f, // Iniciar da posição mais à direita
        targetValue = -500f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val cloud4XPosition by infiniteTransition.animateFloat(
        initialValue = 800f, // Iniciar da posição mais à direita
        targetValue = -500f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Nuvens
        CloudShape(modifier = Modifier.offset(x = cloud1XPosition.dp, y = 200.dp))
        CloudShape(modifier = Modifier.offset(x = cloud2XPosition.dp, y = 100.dp))
        CloudShape(modifier = Modifier.offset(x = cloud3XPosition.dp, y = 300.dp))
        CloudShape(modifier = Modifier.offset(x = cloud4XPosition.dp, y = 250.dp))
    }
}

@Composable
fun CloudShape(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.8f))
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.9f))
                .offset(20.dp, 10.dp)
        )
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.95f))
                .offset(40.dp, 20.dp)
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.9f))
                .offset(70.dp, 0.dp)
        )
    }
}



