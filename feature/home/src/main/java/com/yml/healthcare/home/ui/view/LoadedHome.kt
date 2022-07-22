package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yml.design.card.HCard
import com.yml.design.elements.Header
import com.yml.design.elements.Link
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
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Header(
                    text = data.articleHeader,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp)
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
                                .fillParentMaxWidth(.7f)
                                .clickable {
                                    userIntent(HomeUserIntent.NavigateToArticleDetail(it.url))
                                },
                            title = it.title,
                            description = it.description,
                            tags = it.tags
                        )
                    }
                }

            }
        }

        data.displayBlogs?.let {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Header(
                    text = data.blogHeader,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                )

                Link(text = "View All >") {
                    // todo navigate to article list page
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
                        )
                    }
                }
            }
        }
    }
}