package com.example.brevisimo_news.screens.category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brevisimo_news.data.local.CategoryDataSource
import com.example.brevisimo_news.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val homeRepository: HomeRepository
    ) : ViewModel() {

    private val _categoryUiState = MutableStateFlow(CategoryUiState())
    val categoryUiState: StateFlow<CategoryUiState> = _categoryUiState.asStateFlow()

    init {}

    private fun loadNewsByCategory(category: String) {
        viewModelScope.launch {
            _categoryUiState.update { currentState ->
                currentState.copy(isLoading = true, isError = false)
            }

            try {
                val newsByCategory = homeRepository.getCategoryContent(category = category )
                _categoryUiState.update { currentState->
                    currentState.copy(
                        newsByCategory = newsByCategory,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("DATA_ERROR", "Fallo al obtener noticias: ${e.message}", e)
                _categoryUiState.update { currentState ->
                    currentState.copy(
                        isError = true,
                        isLoading = false,
                        newsByCategory = emptyList()
                    )
                }
            }
        }
    }
}