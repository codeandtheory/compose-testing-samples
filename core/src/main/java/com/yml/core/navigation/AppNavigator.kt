package com.yml.core.navigation

interface AppNavigator {
    fun navigateToArticleList()
    fun navigateToArticleDetail(url: String, title: String)
}