package com.example.brevisimo_news.screens.bookmarks

import com.example.brevisimo_news.domain.model.BookmarksDto

data class BookmarksUiState(
    val bookmarksDto: List<BookmarksDto> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isAppLoading: Boolean = false
)