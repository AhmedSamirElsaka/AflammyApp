package com.example.aflammy.ui.category.uiState

import androidx.paging.PagingData
import com.example.aflammy.utilities.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CategoryUIState(
    val genre: List<GenreUIState> = emptyList(),
    val selectedCategoryID :Int = Constants.FIRST_CATEGORY_ID,
    val media: Flow<PagingData<CategoryMediaUIState>> = emptyFlow(),
    val isLoading: Boolean = false,
    val error: List<CategoryErrorUIState> = emptyList()
)



