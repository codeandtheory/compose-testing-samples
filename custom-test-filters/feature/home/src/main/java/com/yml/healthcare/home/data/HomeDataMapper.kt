package com.yml.healthcare.home.domain

import androidx.core.text.HtmlCompat
import com.yml.core.utils.orEmpty
import com.yml.healthcare.home.data.model.ArticleDTO
import com.yml.healthcare.home.data.model.ArticleListDTO
import com.yml.healthcare.home.data.model.BlogDTO
import com.yml.healthcare.home.data.model.BlogListDTO
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.model.Blog

fun ArticleListDTO.toArticleList(): List<Article> {
    return articles?.let { list ->
        list.filter { it.language == "en" }.map { it.toArticle() }
    } ?: listOf()
}

fun ArticleDTO.toArticle(): Article {
    return Article(
        title = title.orEmpty(),
        tags = tags ?: listOf(),
        url = url.orEmpty(),
        description = HtmlCompat.fromHtml(content.orEmpty(), 0).toString()
    )
}


fun BlogListDTO.toBlogList(): List<Blog> {
    return blogs?.let { list ->
        list.filter { it.lang == "en" }.map { it.toBlog() }
    } ?: listOf()
}

fun BlogDTO.toBlog(): Blog {
    return Blog(
        title = title.orEmpty(),
        tags = tags ?: listOf(),
        url = url.orEmpty(),
        description = HtmlCompat.fromHtml(content.orEmpty(), 0).toString()
    )
}