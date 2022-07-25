package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.model.Blog
import com.yml.healthcare.home.domain.model.HomeDataModel
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LoadedHomeKtTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testArticlesList() {
        val mockData = HomeDataModel(
            displayArticles = mockArticleList()
        )
        with(composeRule) {
            setContent {
                LoadedHomeScreen(modifier = Modifier.fillMaxSize(), data = mockData) {

                }
            }
            compareScreenshot(this, "HomeLoadedArticlesOnly")
        }
    }

    @Test
    fun testBlogList() {
        val mockData = HomeDataModel(
            displayBlogs = mockBlogList()
        )
        with(composeRule) {
            setContent {
                LoadedHomeScreen(modifier = Modifier.fillMaxSize(), data = mockData) {

                }
            }
            compareScreenshot(this, "HomeLoadedBlogsOnly")
        }
    }

    @Test
    fun testBlogAndArticlesList() {
        val mockData = HomeDataModel(
            displayBlogs = mockBlogList(),
            displayArticles = mockArticleList()
        )
        with(composeRule) {
            setContent {
                LoadedHomeScreen(modifier = Modifier.fillMaxSize(), data = mockData) {

                }
            }
            compareScreenshot(this, "HomeLoadedBlogsArticles")
        }
    }

    private fun mockArticleList(): List<Article> {
        val mock = mutableListOf<Article>()
        for (i in 0..4) {
            mock.add(
                Article(
                    title = "Lower Costs on market place coverage $i",
                    description = "Still need Hearlh Insurance?\nYou can get health coverage for the rest of the year if....",
                    url = "",
                    tags = listOf("Blog", "Insurance")
                )
            )
        }
        return mock
    }

    private fun mockBlogList(): List<Blog> {
        val mock = mutableListOf<Blog>()
        for (i in 0..4) {
            mock.add(
                Blog(
                    title = "Lower Costs on market place coverage $i",
                    description = "Still need Hearlh Insurance?\nYou can get health coverage for the rest of the year if....",
                    url = "",
                    tags = listOf("Blog", "Insurance")
                )
            )
        }
        return mock
    }

}