package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yml.design.container.HCToolBarScreen
import com.yml.design.error.ErrorWidget
import com.yml.design.progress.HCProgressBar
import com.yml.healthcare.home.ui.viewmodel.articles.ArticleUserIntent
import com.yml.healthcare.home.ui.viewmodel.articles.ArticleViewModel
import com.yml.healthcare.home.ui.viewmodel.articles.ArticlesNavEffect
import com.yml.healthcare.home.ui.viewmodel.articles.ArticlesViewState
import kotlinx.coroutines.flow.Flow

@Composable
fun ArticleListDestination(viewModel: ArticleViewModel) {
    val state = viewModel.viewState.collectAsState()
    ArticleListDestination(
        viewState = state,
        effect = viewModel.homeEffect
    ) {
        viewModel.performAction(it)
    }
}

@Composable
private fun ArticleListDestination(
    viewState: State<ArticlesViewState>,
    effect: Flow<ArticlesNavEffect>,
    userIntent: (ArticleUserIntent) -> Unit
) {
    val state = viewState.value
    HCToolBarScreen(
        title = state.screenTitle,
        leftIcon = com.yml.design.R.drawable.ic_angle_left,
        modifier = Modifier.background(color = Color.White)
    ) { modifier, snackMessage ->

        fun handleEffects(effect: ArticlesNavEffect) {
            when (effect) {
                ArticlesNavEffect.NavigateToArticleDetail -> {}
                is ArticlesNavEffect.SnackMessage -> {
                    snackMessage(effect.message)
                }
                else -> {}
            }
        }

        LaunchedEffect(Unit) {
            effect.collect {
                handleEffects(it)
            }
        }

        when (state) {
            is ArticlesViewState.Error -> {
                ErrorWidget(
                    data = state.error, modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                )
            }
            is ArticlesViewState.InitialLoading -> {
                HCProgressBar()
            }

            is ArticlesViewState.Loaded -> {
                ArticleListScreen(modifier, state.data)
            }

            is ArticlesViewState.UnInitialized -> {
                userIntent(ArticleUserIntent.FetchArticles)
            }
            else -> {}
        }
    }
}
