package com.example.ghidmaramures.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy

data class TabItem(val label: String, val icon: ImageVector, val route: Any)

val tabs = listOf(
    TabItem("Categorii", Icons.AutoMirrored.Filled.List, CategoriesGraph),
    TabItem("Favorite", Icons.Filled.Favorite, Favorites),
    TabItem("Despre", Icons.Filled.Info, About)
)

@Composable
fun BottomBar(navController: NavController, currentDestination: NavDestination?) {
    NavigationBar {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.hasRoute(tab.route::class) } == true,
                onClick = {
                    navController.navigate(tab.route) {
                        popUpTo(navController.graph.id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) }
            )
        }
    }
}