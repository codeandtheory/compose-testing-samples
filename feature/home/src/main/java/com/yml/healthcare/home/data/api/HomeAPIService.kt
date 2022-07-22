package com.yml.healthcare.home.data.api

import com.yml.healthcare.home.data.model.ArticleListDTO
import com.yml.healthcare.home.data.model.BlogListDTO
import retrofit2.http.GET

interface HomeAPIService {

    @GET("/api/articles.json")
    suspend fun getArticles(): ArticleListDTO

    @GET("/api/blog.json")
    suspend fun fetchBlogs(): BlogListDTO
}