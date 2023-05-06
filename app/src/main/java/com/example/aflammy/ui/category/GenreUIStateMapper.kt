package com.example.aflammy.ui.category

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Genre
import com.example.aflammy.ui.category.uiState.GenreUIState
import javax.inject.Inject

class GenreUIStateMapper @Inject constructor() : Mapper<Genre, GenreUIState> {
    override fun map(input: Genre): GenreUIState {
        return GenreUIState(
            genreID = input.genreID,
            genreName = input.genreName
        )
    }
}