package com.fizz.notfakenews.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fizz.notfakenews.model.Article

@Dao
interface ArticleDao {

    @Insert
    suspend fun insertArticle(article:List<Article>)

    @Query("SELECT * FROM ArticleTable")
    suspend fun getArticles():List<Article>
}
