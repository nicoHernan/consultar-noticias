package com.example.brevisimo_news.screens.bookmarks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brevisimo_news.data.repository.AuthRepository
import com.example.brevisimo_news.data.repository.SupabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val supabaseRepository: SupabaseRepository,
    private val authRepository: AuthRepository
): ViewModel(){
    private val _bookmarksUiState = MutableStateFlow(BookmarksUiState())
    val bookmarksUiState: StateFlow<BookmarksUiState> = _bookmarksUiState.asStateFlow()

    init {
        loadBookmarks()
    }

    fun loadBookmarks() {
        viewModelScope.launch {
            val currentUser = authRepository.getCurrentUser()
            if (currentUser != null && !currentUser.isAnonymous) {

                _bookmarksUiState.update { currentState ->
                    currentState.copy(isAppLoading = true, isError = false)
                }
                try {
                    val bookmarksDto = supabaseRepository.getBookmarks(currentUser.uid)
                    _bookmarksUiState.update { currentState ->
                        currentState.copy(
                            bookmarksDto = bookmarksDto,
                            isAppLoading = false
                        )
                    }
                } catch (e: Exception) {
                    Log.e("DATA_ERROR", "Fallo al obtener noticias: ${e.message}", e)
                    _bookmarksUiState.update { currentState ->
                        currentState.copy(
                            isError = true,
                            isAppLoading = false,
                            bookmarksDto = emptyList()
                        )
                    }
                }
            }
        }
    }


    fun deleteBookmark(bookmarksId: String) {
        viewModelScope.launch {
            try {
                // Necesitarás agregar deleteBookmark a tu SupabaseRepository
                supabaseRepository.deleteBookmark(bookmarksId)
                // Actualizamos la lista localmente para que sea instantáneo
                _bookmarksUiState.update { currentState ->
                    currentState.copy(
                        bookmarksDto = currentState.bookmarksDto.filter { bookmarksDto->
                            bookmarksDto.bookmarksId != bookmarksId
                        })
                }
            } catch (e: Exception) { /* Manejar error */ }
        }
    }
}