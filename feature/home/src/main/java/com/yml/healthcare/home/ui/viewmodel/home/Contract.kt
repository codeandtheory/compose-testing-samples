package com.yml.healthcare.home.ui.viewmodel.home

import com.yml.design.error.ErrorData
import com.yml.healthcare.home.domain.model.HomeDataModel

sealed class HomeViewState(val screenTitle: String = "Home") {
    class UnInitialized : HomeViewState()
    class InitialLoading : HomeViewState()
    class Loaded(val data: HomeDataModel) : HomeViewState()
    class Error(val error: ErrorData) : HomeViewState()
}

sealed class HomeUserIntent {

    class NavigateToArticleDetail(val url: String) : HomeUserIntent()

    object FetchHomeData : HomeUserIntent()

    object ViewAllArticles : HomeUserIntent()

    object ViewShowkaseBrowser : HomeUserIntent()
}

sealed class HomeEffect {
    class NavigateToArticleDetail(val url: String) : HomeEffect()

    object ViewAllArticles : HomeEffect()

    class SnackMessage(val message: String) : HomeEffect()

    object ViewShowkaseBrowser : HomeEffect()
}