package com.example.ghidmaramures.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ghidmaramures.ui.LoginScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(PlaceList) {
                        popUpTo<Login> { inclusive = true }
                    }
                }
            )
        }
        composable<PlaceList> {
            Text("Aici va fi lista")
        }
    }
}