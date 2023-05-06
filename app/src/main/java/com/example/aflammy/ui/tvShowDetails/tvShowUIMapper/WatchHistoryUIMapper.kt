package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.WatchHistory
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.WatchHistoryUIState
import javax.inject.Inject


class WatchHistoryUIMapper @Inject constructor() : Mapper<WatchHistoryUIState, WatchHistory> {
    override fun map(input: WatchHistoryUIState): WatchHistory {
        return WatchHistory(
            id = input.id,
            posterPath = input.posterPath,
            movieTitle = input.movieTitle,
            movieDuration = input.movieDuration,
            voteAverage = input.voteAverage,
            releaseDate = input.releaseDate,
            mediaType = input.mediaType
        )
    }
}
