package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yml.design.card.HCard
import com.yml.design.elements.HCButton
import com.yml.design.elements.Header
import com.yml.design.elements.Link
import com.yml.healthcare.home.BuildConfig
import com.yml.healthcare.home.domain.model.HomeDataModel
import com.yml.healthcare.home.ui.viewmodel.home.HomeUserIntent

@Composable
fun LoadedHomeScreen(
    modifier: Modifier, data: HomeDataModel,
    userIntent: (HomeUserIntent) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        data.displayArticles?.let {

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Header(
                    text = data.articleHeader
                )

                Link(text = "View All >") {
                    userIntent(HomeUserIntent.ViewAllArticles)
                }
            }

            LazyRow {
                data.displayArticles.forEach {
                    item {
                        HCard(
                            modifier = Modifier
                                .fillParentMaxWidth(.7f),
                            title = it.title,
                            description = it.description,
                            tags = it.tags
                        ) {
                            userIntent(HomeUserIntent.NavigateToArticleDetail(it.url))
                        }
                    }
                }

            }
        }

        data.displayBlogs?.let {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Header(
                    text = data.blogHeader
                )
                Link(text = "View All >") {
                    userIntent(HomeUserIntent.ViewAllArticles)
                }
            }
            LazyRow {
                data.displayBlogs.forEach {
                    item {
                        HCard(
                            modifier = Modifier.fillParentMaxWidth(.7f),
                            title = it.title,
                            description = it.description,
                            tags = it.tags
                        ) {
                            userIntent(HomeUserIntent.NavigateToArticleDetail(it.url))
                        }
                    }
                }
            }
        }
    }
}