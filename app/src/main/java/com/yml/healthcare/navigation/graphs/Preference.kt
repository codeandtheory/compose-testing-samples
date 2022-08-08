package com.yml.healthcare.navigation.graphs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yml.design.container.HCToolBarScreen
import com.yml.design.error.ErrorData
import com.yml.design.error.ErrorWidget
import com.yml.healthcare.ui.theme.GraphRoute
import com.yml.healthcare.ui.theme.NavigationCommand


fun NavGraphBuilder.preferencesGraph() {
    navigation(
        startDestination = NavigationCommand.Preferences.route,
        route = GraphRoute.Settings.route
    ) {
        composable(NavigationCommand.Preferences.route) {
            HCToolBarScreen(title = "Preferences") { modifier, y ->
                ErrorWidget(
                    data = ErrorData(
                        title = "Coming Soon",
                        description = "Feature is yet to be implemented"
                    ),
                    modifier = modifier.fillMaxSize()
                )
            }
        }
    }
}