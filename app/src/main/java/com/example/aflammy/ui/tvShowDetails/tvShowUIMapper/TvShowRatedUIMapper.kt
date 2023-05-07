package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Rated
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowRatedUIState
import javax.inject.Inject


class TvShowRatedUIMapper @Inject constructor() : Mapper<Rated, TvShowRatedUIState> {
    override fun map(input: Rated): TvShowRatedUIState {
        return TvShowRatedUIState(
            id = input.id,
            rating = input.rating,
        )
    }
}
