package com.example.aflammy.ui.youtubePlayer

import com.example.aflammy.ui.category.uiState.ErrorUIState

data class TrailerUIState(
    val videoKey: String = "",
    val isLoading: Boolean = false,
    val error: List<ErrorUIState> = emptyList()
)