package com.yml.healthcare.navigation

import android.content.Context
import androidx.navigation.NavHostController
import com.yml.core.navigation.AppNavigator
import com.yml.design.browserIntent
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

    override fun navigateBack() {
        controller.popBackStack()
    }

    override fun navigateToShowKaseBrowser(context: Context) {
        context.startActivity(browserIntent(context))
    }
}