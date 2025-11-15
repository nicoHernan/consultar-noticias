package com.example.brevisimo_news.screens.category

import com.example.brevisimo_news.domain.model.MediaDto

data class CategoryUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val newsByCategory: List<MediaDto> = emptyList()
)
