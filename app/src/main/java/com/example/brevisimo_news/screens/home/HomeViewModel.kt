package com.example.brevisimo_news.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brevisimo_news.data.repository.HomeRepository
import com.example.brevisimo_news.domain.model.ArticleDto
import com.example.brevisimo_news.domain.model.MediaDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    private val _sideEffects = Channel<HomeSideEffect>(Channel.BUFFERED)
    val sideEffects = _sideEffects.receiveAsFlow()

    init {
        loadListOfCategory()
        loadNewsInUs()
        loadMediaSourcesForDrawer()
    }




    private fun loadMediaSourcesForDrawer() {
        val mediaSources = homeRepository.getLocalMediaSources()

        _homeUiState.update { currentState ->
            currentState.copy(
                newsByDomain = mediaSources
            )
        }
    }

    fun onDrawerMediaClick(mediaDto: MediaDto) {
        viewModelScope.launch {
            mediaDto.url.let { url ->
                if (url.isNotEmpty()) {
                    _sideEffects.send(HomeSideEffect.OpenExternalUrl(url))
                }
            }
        }
    }

    fun onArticleDto(articleDto: ArticleDto) {
        viewModelScope.launch {
            articleDto.url.let { url ->
                if (url.isNotEmpty()) {
                    _sideEffects.send(HomeSideEffect.OpenExternalUrl(url))
                }
            }
        }
    }

    private fun loadNewsInUs() {
        viewModelScope.launch {
            _homeUiState.update { currentState ->
                currentState.copy(isLoading = true, isError = false)
            }

            try {
                val newsInUs = homeRepository.getMediaInUs(country = "us" )
                _homeUiState.update { currentState->
                    currentState.copy(
                        newsInUs = newsInUs,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("DATA_ERROR", "Fallo al obtener noticias: ${e.message}", e)
                _homeUiState.update { currentState ->
                    currentState.copy(
                        isError = true,
                        isLoading = false,
                        newsInUs = emptyList()
                    )
                }
            }
        }
    }



    private fun loadListOfCategory() {
        _homeUiState.update { currentState ->
            currentState.copy(categories = homeRepository.getLocalCategories())
        }
    }



    val filteredArticles: StateFlow<List<ArticleDto>> = homeUiState
            .map { uiState ->
                val originalList = uiState.newsInUs
                val query = uiState.valueSearch.trim().lowercase()

                if (query.isBlank()) {
                    originalList
                } else {

                    originalList.filter { article ->

                        val titleMatch = article.title.lowercase().contains(query)
                        val descriptionMatch = article.description?.lowercase()?.contains(query) ?: false

                        titleMatch || descriptionMatch
                    }
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    fun onSearch(newValue: String){
        _homeUiState.update { currentState->
            currentState.copy(valueSearch = newValue)
        }
    }
}