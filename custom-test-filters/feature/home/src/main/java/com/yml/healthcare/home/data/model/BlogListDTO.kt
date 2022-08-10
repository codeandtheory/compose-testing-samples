package com.yml.healthcare.home.data.model

import com.google.gson.annotations.SerializedName

data class BlogListDTO(
    @SerializedName("blog")
    val blogs: List<BlogDTO>?
)

data class BlogDTO(
    val title: String?,
    val lang: String?,
    val content: String?,
    val date: String?,
    val topics: List<String>?,
    val categories: List<String>?,
    val tags: List<String>?,
    val url: String?
)