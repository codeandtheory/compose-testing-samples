package com.yml.healthcare.navigation.graphs

import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.healthcare.navigation.DummyDestination
import com.yml.healthcare.ui.theme.GraphRoute
import com.yml.healthcare.ui.theme.NavigationCommand

fun NavGraphBuilder.searchGraph() {
    navigation(
        startDestination = NavigationCommand.Search.route,
        route = GraphRoute.Search.route
    ) {
        composable(NavigationCommand.Search.route) {
            DummyDestination(color = Color.Magenta, title = "Search")
        }
    }
}