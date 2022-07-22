package com.yml.healthcare.navigation

import androidx.navigation.NavHostController
import com.yml.core.navigation.AppNavigator
import com.yml.healthcare.ui.theme.NavigationCommand

class NavigationManager(
    private val controller: NavHostController
) : AppNavigator {

    override fun navigateToArticleList() {
        controller.navigate(NavigationCommand.Articles.route)
    }

    override fun navigateToArticleDetail(url: String, title: String) {
        controller.navigate(NavigationCommand.WebView.route(url, title))
    }
}