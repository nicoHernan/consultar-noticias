package com.example.brevisimo_news.data.repository

import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.BookmarkDto

interface SupabaseRepository {
    suspend fun saveToBookmarks(bookmark: BookmarkDto)
    suspend fun saveArticleAsBookmark(article: ArticleDto, userId: String)
    suspend fun getBookmarks(userId: String): List<BookmarkDto>
    suspend fun deleteBookmark(bookmarkId: String)
}