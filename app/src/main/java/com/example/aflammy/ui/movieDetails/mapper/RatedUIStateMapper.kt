package com.example.aflammy.ui.movieDetails.mapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Rated
import com.example.aflammy.ui.movieDetails.movieDetailsUIState.RatedUIState
import javax.inject.Inject


class RatedUIStateMapper @Inject constructor() : Mapper<Rated, RatedUIState> {
    override fun map(input: Rated): RatedUIState {
        return RatedUIState(
            id = input.id,
            rating = input.rating,
        )
    }
}