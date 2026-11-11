package com.example.ghidmaramures.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ghidmaramures.data.Category
import com.example.ghidmaramures.ui.LoginScreen
import com.example.ghidmaramures.ui.PlaceListScreen

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
            var filtru by rememberSaveable { mutableStateOf<Category?>(null) }
            PlaceListScreen(
                selectedCategory = filtru,
                onCategorySelected = { filtru = it },
                onPlaceClick = {}
            )
        }
    }
}