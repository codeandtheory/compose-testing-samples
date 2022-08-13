package com.yml.healthcare.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yml.core.navigation.AppNavigator
import com.yml.healthcare.navigation.bottomNav.HealthCareBottomNavWrapper
import com.yml.healthcare.navigation.graphs.homeScreenGraph
import com.yml.healthcare.navigation.graphs.preferencesGraph
import com.yml.healthcare.navigation.graphs.searchGraph
import com.yml.healthcare.ui.theme.GraphRoute
import com.yml.healthcare.ui.theme.NavigationCommand
import com.yml.launcher.SplashDestination

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = NavigationCommand.Splash.route, // Starting destination in this Graph Builder
        route = GraphRoute.Root.route // Root of this Graph
    ) {
        composable(NavigationCommand.Splash.route) {
            SplashDestination {
                navController.popBackStack() // splash should not be there in the back stack
                navController.navigate(GraphRoute.Home.route)
            }
        }

        composable(GraphRoute.Home.route) {
            PostLaunch()
        }
    }
}


@Composable
fun PostLaunch(navController: NavHostController = rememberNavController()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
            HealthCareBottomNavWrapper(navHostController = navController)
        }) {
        HealthcareNavHost(
            navController = navController,
            NavigationManager(navController)
        )
    }
}

@Composable
fun HealthcareNavHost(
    navController: NavHostController,
    appNavigator: AppNavigator
) {
    NavHost(
        navController = navController,
        startDestination = GraphRoute.Home.route, // Corresponds to dashboard
        route = GraphRoute.Root.route // Root of this Navigation Graph
    ) {
        homeScreenGraph(appNavigator)
        preferencesGraph()
        searchGraph()
    }
}

//TODO Replace with feature screens
@Composable
fun DummyDestination(color: Color, title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, style = TextStyle(color = Color.White))
    }
}