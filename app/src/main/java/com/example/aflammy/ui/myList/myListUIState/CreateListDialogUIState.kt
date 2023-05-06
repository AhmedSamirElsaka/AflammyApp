package com.example.aflammy.ui.myList.myListUIState

import com.example.aflammy.ui.category.uiState.ErrorUIState

data class CreateListDialogUIState(
    val mediaListName: String = "",
    val error: List<ErrorUIState> = emptyList()
)