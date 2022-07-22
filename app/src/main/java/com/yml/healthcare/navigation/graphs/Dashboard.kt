package com.yml.healthcare.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.yml.core.constants.NetworkConstants
import com.yml.core.navigation.AppNavigator
import com.yml.healthcare.home.ui.view.ArticleListDestination
import com.yml.healthcare.home.ui.view.HCWebView
import com.yml.healthcare.home.ui.view.HomeDestination
import com.yml.healthcare.home.ui.viewmodel.articles.ArticleViewModel
import com.yml.healthcare.home.ui.viewmodel.home.HomeViewModel
import com.yml.healthcare.navigation.ArgumentId
import com.yml.healthcare.ui.theme.GraphRoute
import com.yml.healthcare.ui.theme.NavigationCommand

fun NavGraphBuilder.homeScreenGraph(navigator: AppNavigator) {
    navigation(
        startDestination = NavigationCommand.Dashboard.route,
        route = GraphRoute.Home.route // to be used by the Nav host if keeping start destination, can redirect to this graph
    ) {

        composable(route = NavigationCommand.Dashboard.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeDestination(viewModel = viewModel, navigator)
        }

        composable(NavigationCommand.Articles.route) {
            val viewModel = hiltViewModel<ArticleViewModel>()
            ArticleListDestination(viewModel = viewModel)
        }

        composable(
            NavigationCommand.WebView.route,
            arguments = listOf(
                navArgument(ArgumentId.PATH) {
                    type = NavType.StringType
                },
                navArgument(ArgumentId.SCREEN_TITLE) {
                    type = NavType.StringType
                    nullable = false
                    defaultValue = ""
                }
            )
        ) {

            it.arguments?.let { args ->
                HCWebView(
                    url = NetworkConstants.API_END_POINT + args.getString(ArgumentId.PATH, ""),
                    args.getString(ArgumentId.SCREEN_TITLE, "")
                )
            }

        }
    }
}