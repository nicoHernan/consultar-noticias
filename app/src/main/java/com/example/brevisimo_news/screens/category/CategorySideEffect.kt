package com.example.brevisimo_news.screens.category

import com.example.brevisimo_news.screens.home.HomeSideEffect


sealed interface CategorySideEffect {
    data class OpenExternalUrl(val url: String): CategorySideEffect
}