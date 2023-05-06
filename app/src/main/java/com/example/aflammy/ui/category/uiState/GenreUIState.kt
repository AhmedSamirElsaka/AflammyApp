package com.example.aflammy.ui.category.uiState

import com.example.aflammy.utilities.Constants

data class GenreUIState(
    val genreID: Int = Constants.FIRST_CATEGORY_ID,
    val genreName: String = ""
)
