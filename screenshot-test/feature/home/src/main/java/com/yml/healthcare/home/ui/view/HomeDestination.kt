package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.yml.core.navigation.AppNavigator
import com.yml.design.container.HCToolBarScreen
import com.yml.design.error.ErrorWidget
import com.yml.design.progress.HCProgressBar
import com.yml.healthcare.home.R
import com.yml.healthcare.home.ui.viewmodel.home.HomeEffect
import com.yml.healthcare.home.ui.viewmodel.home.HomeUserIntent
import com.yml.healthcare.home.ui.viewmodel.home.HomeViewState
import com.yml.healthcare.home.ui.viewmodel.home.HomeViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeDestination(
    viewModel: HomeViewModel,
    navController: AppNavigator
) {
    val homeState = viewModel.viewState.collectAsState()
    HomeDestination(
        viewState = homeState,
        effect = viewModel.homeEffect,
        navController
    ) {
        viewModel.performAction(it)
    }
}

@Composable
private fun HomeDestination(
    viewState: State<HomeViewState>,
    effect: Flow<HomeEffect>,
    navController: AppNavigator,
    userIntent: (HomeUserIntent) -> Unit
) {
    val state = viewState.value
    HCToolBarScreen(
        title = state.screenTitle,
        leftIcon = com.yml.design.R.drawable.ic_menu_burger,
        headerImage = R.drawable.health_care_gov,
    ) { modifier, snackMessage ->

        val context = LocalContext.current

        fun handleEffects(homeEffect: HomeEffect) {
            when (homeEffect) {
                is HomeEffect.NavigateToArticleDetail -> {
                    navController.navigateToArticleDetail(homeEffect.url, "Article")
                }

                HomeEffect.ViewAllArticles -> {
                    navController.navigateToArticleList()
                }

                is HomeEffect.SnackMessage -> {
                    snackMessage(homeEffect.message)
                }
                is HomeEffect.ViewShowkaseBrowser -> {
                    navController.navigateToShowKaseBrowser(context)
                }
            }
        }

        LaunchedEffect(Unit) {
            effect.collect {
                handleEffects(it)
            }
        }

        when (state) {
            is HomeViewState.Error -> {
                ErrorWidget(
                    data = state.error, modifier = Modifier
                        .fillMaxSize()
                )
            }
            is HomeViewState.InitialLoading -> {
                HCProgressBar()
            }

            is HomeViewState.Loaded -> {
                LoadedHomeScreen(modifier, state.data, userIntent)
            }

            is HomeViewState.UnInitialized -> {
                userIntent(HomeUserIntent.FetchHomeData)
            }
        }
    }
}
