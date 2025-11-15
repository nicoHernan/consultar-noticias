package com.example.brevisimo_news.screens.category

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.brevisimo_news.NewsAppState

@Composable
fun CategoryScreen (
    modifier: Modifier = Modifier,
    categoryName: String,
    categoryViewModel: CategoryViewModel = hiltViewModel(),
    windowSizeClass: WindowSizeClass,
    appState: NewsAppState
){

    val categoryUiState by categoryViewModel.categoryUiState.collectAsStateWithLifecycle()
}