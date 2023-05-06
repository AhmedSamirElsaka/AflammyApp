package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Season
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.SeasonUIState
import javax.inject.Inject


class TvShowSeasonUIMapper @Inject constructor() : Mapper<Season, SeasonUIState> {
    override fun map(input: Season): SeasonUIState {
        return SeasonUIState(
            seasonName = input.seasonName,
            seasonNumber = input.seasonNumber,
            imageUrl = input.imageUrl,
            episodeCount = input.episodeCount,
            seasonYear = input.seasonYear,
            seasonDescription = input.seasonDescription,
        )
    }
}
