package com.example.brevisimo_news.screens.home

sealed interface HomeSideEffect {
    data class OpenExternalUrl(val url: String): HomeSideEffect
    data object NavigateToLogin : HomeSideEffect
}