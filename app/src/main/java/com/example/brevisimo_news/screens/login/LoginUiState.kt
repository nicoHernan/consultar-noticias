package com.example.brevisimo_news.screens.login

data class LoginUiState (
    val isLoading: Boolean = false,
    val isError: String? = null,
    val isSuccess: Boolean = false
)