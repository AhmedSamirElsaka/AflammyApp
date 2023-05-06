package com.example.aflammy.ui.myList.listDetails.listDetailsUIState

import com.example.aflammy.ui.category.uiState.ErrorUIState


data class ListDetailsUIState(
    val savedMedia: List<SavedMediaUIState> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val error: List<ErrorUIState> = emptyList()
)