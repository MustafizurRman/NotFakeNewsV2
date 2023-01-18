package com.fizz.notfakenews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fizz.notfakenews.model.NotNews
import com.fizz.notfakenews.network.NewsApiService

class ArticleRepository(private val apiInterface:NewsApiService,private val articleDatabase: ArticleDatabase) {
    private val articleLiveData= MutableLiveData<NotNews>()

    val articleLD:LiveData<NotNews> get() = articleLiveData

    suspend fun getArticles(){
        val result= apiInterface.getTopNewsUS()
        if(result!=null){
            articleDatabase.articleDao().insertArticle(result!!.articles)
            articleLiveData.postValue(result)
        }
    }
}
