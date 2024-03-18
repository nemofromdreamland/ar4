 package br.com.ar

import br.com.ar.screens.EscolhaCidade
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ar.screens.Aprenda
import br.com.ar.screens.LoginScreen
import br.com.ar.ui.theme.ArTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "start"
                    ){
                        composable(route = "start"){ LoginScreen(navController)}
                        composable(route = "aprenda"){ Aprenda(navController)}
                        composable(route = "escolha"){ EscolhaCidade(navController) }
                    }
                }
            }
        }
    }
}

