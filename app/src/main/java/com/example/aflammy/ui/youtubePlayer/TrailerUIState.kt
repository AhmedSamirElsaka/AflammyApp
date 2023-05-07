package com.example.aflammy.ui.youtubePlayer

import com.example.aflammy.ui.category.uiState.CategoryErrorUIState

data class TrailerUIState(
    val videoKey: String = "",
    val isLoading: Boolean = false,
    val error: List<CategoryErrorUIState> = emptyList()
)