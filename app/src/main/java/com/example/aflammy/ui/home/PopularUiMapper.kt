package com.example.aflammy.ui.home

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.PopularMovie
import com.example.aflammy.ui.home.models.PopularUiState
import javax.inject.Inject

class PopularUiMapper @Inject constructor() : Mapper<PopularMovie, PopularUiState> {
    override fun map(input: PopularMovie): PopularUiState {
        return input.let {
            PopularUiState(
                it.movieID,
                it.title,
                it.imageUrl,
                it.movieRate,
                it.genre
            )
        }
    }
}