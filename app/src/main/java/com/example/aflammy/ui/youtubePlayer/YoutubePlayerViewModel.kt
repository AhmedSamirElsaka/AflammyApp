package com.example.aflammy.ui.youtubePlayer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.aflammy.domain.usecases.GetTrailerUseCase
import com.example.aflammy.ui.base.BaseViewModel
import com.example.aflammy.ui.category.uiState.CategoryErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YoutubePlayerViewModel @Inject constructor(
    private val getTrailerUseCase: GetTrailerUseCase,
    state: SavedStateHandle
) : BaseViewModel() {

    private val args = YoutubePlayerActivityArgs.fromSavedStateHandle(state)

    private val _trailerUIState = MutableStateFlow(TrailerUIState())
    val trailerUIState = _trailerUIState.asStateFlow()

    init {
        getData()
    }

    override fun getData() {
        _trailerUIState.update { it.copy(isLoading = true, error = emptyList()) }
        viewModelScope.launch {
            try {
                val response = getTrailerUseCase(args.type, args.movieId)
                _trailerUIState.update { it.copy(isLoading = false, videoKey = response.videoKey) }
            } catch (t: Throwable) {
                _trailerUIState.update {
                    it.copy(
                        isLoading = false,
                        error = listOf(CategoryErrorUIState(404, t.message.toString()))
                    )
                }
            }
        }
    }

}