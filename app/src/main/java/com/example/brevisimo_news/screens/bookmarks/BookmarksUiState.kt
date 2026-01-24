package com.example.brevisimo_news.screens.bookmarks

import com.example.brevisimo_news.domain.model.BookmarkDto

data class BookmarksUiState(
    val bookmarksDto: List<BookmarkDto> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isAppLoading: Boolean = false,
)