package com.example.brevisimo_news.data.repository

import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.BookmarkDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import javax.inject.Inject

class SupabaseImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : SupabaseRepository {
    override suspend fun saveToBookmarks(bookmark: BookmarkDto) {
        supabaseClient.from(table = "bookmarks").insert(value = bookmark)
    }

    override suspend fun saveArticleAsBookmark(
        article: ArticleDto,
        userId: String
    ) {
        val bookmark = BookmarkDto(
            userId = userId,
            title = article.title,
            url = article.url,
            id = null,
            imageUrl = article.urlToImage ?: ""
        )
        supabaseClient.from("bookmarks").insert(bookmark)
    }

    override suspend fun getBookmarks(userId: String): List<BookmarkDto> {
        return supabaseClient
            .from(table = "bookmarks")
            .select {
                filter {
                    eq(column = "user_id", userId)
                }
            }
            .decodeList<BookmarkDto>()
    }

    override suspend fun deleteBookmark(bookmarkId: String) {
        supabaseClient.from("bookmarks").delete {
            filter {
                eq("bookmarks_id", bookmarkId)
            }
        }
    }
}