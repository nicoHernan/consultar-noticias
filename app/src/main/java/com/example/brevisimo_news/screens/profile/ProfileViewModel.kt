package com.example.brevisimo_news.screens.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brevisimo_news.data.local.LayoutPreferences
import com.example.brevisimo_news.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val layoutPreferences: LayoutPreferences
): ViewModel(){

    private val _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState.asStateFlow()

    init {
        loadUserData()
        observeLayoutPreference()
    }


    fun onProfileImage(uri: Uri?) {
        _profileUiState.update { currentState ->
            currentState.copy(tempLocalUri = uri)
        }
    }
    private fun observeLayoutPreference() {
        viewModelScope.launch {
            layoutPreferences.isGridLayout.collect { isGrid ->
                _profileUiState.update {currentState ->
                    currentState.copy(isGridLayout = isGrid)
                }
            }
        }
    }

    fun setLayout(isGrid: Boolean) {
        viewModelScope.launch {
            layoutPreferences.setLayout(isGrid)
        }
    }

    private fun loadUserData() {
        val user = authRepository.getCurrentUser()
        _profileUiState.update { currentState ->
            currentState.copy(
                name = user?.displayName ?: "Usuario de Brevísimo",
                email = user?.email ?: "Sin correo electrónico",
                photoUrl = user?.photoUrl?.toString()
            )
        }
    }
}