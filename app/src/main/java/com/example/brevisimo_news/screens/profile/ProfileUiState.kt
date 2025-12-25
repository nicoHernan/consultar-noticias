package com.example.brevisimo_news.screens.profile

import android.net.Uri

data class ProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val photoUrl: String? = null,
    val isGridLayout: Boolean = false,
    val tempLocalUri: Uri? = null,
    val error: String? = null
)
