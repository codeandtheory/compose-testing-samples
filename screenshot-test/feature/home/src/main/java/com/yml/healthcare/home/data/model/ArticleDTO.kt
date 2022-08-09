package com.yml.healthcare.home.data.model

import com.google.gson.annotations.SerializedName

data class ArticleListDTO(
    @SerializedName("articles")
    val articles: List<ArticleDTO>?
)

data class ArticleDTO(
    @SerializedName("date")
    val date: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("content")
    val content: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("lang")
    val language: String?,

    @SerializedName("tags")
    val tags: List<String>?
)