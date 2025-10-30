package com.example.brevisimo_news.screens.home

import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.MediaDto
import com.example.brevisimo_news.domain.model.SourceDto

data class HomeUiState(
    val newsByDomain: List<MediaDto> = emptyList(),
    val categories: List<String> = emptyList(),
    val newsByCategory: List<MediaDto> = emptyList(),
    val newsInUs: List<ArticleDto> = emptyList(),

    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val valueSearch: String = ""
)