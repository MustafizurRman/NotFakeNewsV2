package com.fizz.notfakenews.model

import androidx.room.Entity

@Entity(tableName = "ArticleTable")
data class Article(
    val author: String?,
    val title: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val url: String?,
    val urlToImage: String?
)