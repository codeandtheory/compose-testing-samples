package com.yml.healthcare.home.domain.model

data class Article(
    val title: String,
    val description: String,
    val tags: List<String>,
    val url: String
) : HomeListItem {
    override fun type(): ItemType {
        return ItemType.ARTICLE
    }
}

data class Header(val title: String) : HomeListItem {
    override fun type(): ItemType {
        return ItemType.HEADER
    }
}

data class Blog(
    val title: String,
    val description: String,
    val tags: List<String>,
    val url: String
) : HomeListItem {
    override fun type(): ItemType {
        return ItemType.BLOGS
    }
}


data class HomeDataModel(
    val displayArticles: List<Article>? = null,
    val articleHeader: String = "Articles",
    val displayBlogs: List<Blog>? = null,
    val blogHeader: String = "Blogs"
)

interface HomeListItem {
    fun type(): ItemType
}

enum class ItemType {
    HEADER,
    ARTICLE,
    BLOGS,
    TOPICS,
}