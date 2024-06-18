package com.example.thikotlin02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Route.Splash) {
                composable(Route.Splash) { SplashScreen(navController) }
                composable(Route.Home) { Home(navController) }
                composable(Route.ADD){ Add_product(XeHoi_Viewmodel(),navController) }
            }
        }
    }
}