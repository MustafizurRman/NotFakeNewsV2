package com.fizz.notfakenews.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fizz.notfakenews.model.Article

@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun articleDao():ArticleDao

    companion object {
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabase(context: Context): ArticleDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, ArticleDatabase::class.java, "articleDB")
                    .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
            return INSTANCE!!
        }
    }
}
