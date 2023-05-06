package com.example.aflammy.ui.movieDetails.saveMovie.uiState

import com.example.aflammy.ui.category.uiState.ErrorUIState

data class MySavedListUIState(
    val myListItemUI: List<MyListItemUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<ErrorUIState> = emptyList()
)

