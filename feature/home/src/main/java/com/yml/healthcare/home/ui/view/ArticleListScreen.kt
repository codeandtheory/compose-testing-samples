package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yml.design.card.HCard
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.ui.viewmodel.articles.ArticleUserIntent
import com.yml.healthcare.home.ui.viewmodel.home.HomeUserIntent

@Composable
fun ArticleListScreen(
    modifier: Modifier,
    data: List<Article>,
    userIntent: (ArticleUserIntent) -> Unit
) {
    LazyColumn(modifier = modifier) {
        data.forEach {
            item {
                HCard(
                    modifier = Modifier.fillParentMaxWidth(),
                    title = it.title,
                    description = it.description,
                    tags = it.tags
                ) {
                    userIntent(ArticleUserIntent.NavigateToDetails(it.url))
                }
            }
        }
    }
}