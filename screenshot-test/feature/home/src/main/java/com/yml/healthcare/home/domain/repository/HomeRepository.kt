package com.yml.healthcare.home.domain.repository

import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.model.Blog

interface HomeRepository {
    suspend fun fetchArticles(): List<Article>

    suspend fun fetchBlogList(): List<Blog>
}