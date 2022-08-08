package com.yml.core.navigation

import android.content.Context

interface AppNavigator {

    fun navigateToArticleList()

    fun navigateToArticleDetail(url: String, title: String)

    fun navigateBack()

    fun navigateToShowKaseBrowser(context: Context)
}