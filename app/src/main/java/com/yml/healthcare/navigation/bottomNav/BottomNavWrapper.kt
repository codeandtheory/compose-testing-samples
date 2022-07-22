package com.yml.healthcare.navigation.bottomNav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yml.design.bottomNavigation.HealthCareBottomNavigation
import com.yml.healthcare.ui.theme.NavigationCommand

@Composable
fun HealthCareBottomNavWrapper(navHostController: NavHostController) {
    val destinations = remember { bottomNavDestinations() }
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (destinations.any { it.route == currentDestination?.route }) {
        // Only enable bottom navigation for the tab screens
        HealthCareBottomNavigation(
            isSelected = { screen ->
                currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } ?: false
            },
            items = destinations
        ) {
            navHostController.navigate(route = it.route) {
                val startDestination = navHostController.graph.findStartDestination().id
                popUpTo(startDestination)
                launchSingleTop = true // This will ensure that selected tab is not recreated
            }
        }
    }

}

private fun bottomNavDestinations() = listOf(
    NavigationCommand.Dashboard,
    NavigationCommand.Search,
    NavigationCommand.Preferences
)