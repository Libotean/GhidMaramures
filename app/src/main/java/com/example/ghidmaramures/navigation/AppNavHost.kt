package com.example.ghidmaramures.navigation

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ghidmaramures.data.Category
import com.example.ghidmaramures.ui.AboutScreen
import com.example.ghidmaramures.ui.FavoritesScreen
import com.example.ghidmaramures.ui.LoginScreen
import com.example.ghidmaramures.ui.PlaceDetailScreen
import com.example.ghidmaramures.ui.PlaceListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    var favorite by rememberSaveable { mutableStateOf(setOf<Int>()) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val showBottomBar = currentDestination != null && !currentDestination.hasRoute(Login::class)

    Scaffold(
        bottomBar = {
            if (showBottomBar) BottomBar(navController, currentDestination)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Login,
            modifier = Modifier.padding(innerPadding).consumeWindowInsets(innerPadding)
        ) {
            composable<Login> {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(CategoriesGraph) {
                            popUpTo<Login> { inclusive = true }
                        }
                    }
                )
            }

            navigation<CategoriesGraph>(startDestination = PlaceList) {
                composable<PlaceList> {
                    var filtru by rememberSaveable { mutableStateOf<Category?>(null) }
                    PlaceListScreen(
                        selectedCategory = filtru,
                        onCategorySelected = { filtru = it },
                        onPlaceClick = { id -> navController.navigate(PlaceDetail(id)) }
                    )
                }

                composable<PlaceDetail> { backStackEntry ->
                    val detail: PlaceDetail = backStackEntry.toRoute()
                    PlaceDetailScreen(
                        placeId = detail.id,
                        isFavorite = detail.id in favorite,
                        onToggleFavorite = {
                            favorite = if (detail.id in favorite) favorite - detail.id
                            else favorite + detail.id
                        },
                        onBack = { navController.popBackStack() }
                    )
                }
            }

            composable<Favorites> {
                FavoritesScreen(
                    favoriteIds = favorite,
                    onRemove = { id -> favorite = favorite - id }
                )
            }

            composable<About> {
                AboutScreen()
            }
        }
    }
}