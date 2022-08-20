package com.yml.healthcare.home.domain.usecase

import com.yml.healthcare.home.domain.model.HomeDataModel
import com.yml.healthcare.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(private val repository: HomeRepository) : HomeUseCase {
    override suspend fun fetchHomeData(): HomeDataModel {
        val blogList = repository.fetchBlogList()
        val articles = repository.fetchArticles()

        return HomeDataModel(
            displayArticles = articles.subList(
                0,
                minOf(articles.size, 4) // to avoid array index out of bound
            ),
            displayBlogs = blogList.subList(
                0,
                minOf(articles.size, 4) // to avoid array index out of bound
            )
        )
    }
}