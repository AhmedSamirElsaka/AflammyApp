package com.example.aflammy.ui.tvShowDetails.tvShowUIMapper

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.WatchHistory
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowDetailsResultUIState
import com.example.aflammy.utilities.Constants
import javax.inject.Inject


class TvShowWatchHistoryMapper @Inject constructor() :
    Mapper<TvShowDetailsResultUIState, WatchHistory> {
    override fun map(input: TvShowDetailsResultUIState): WatchHistory {
        return WatchHistory(
            id = input.tvShowId,
            posterPath = input.tvShowName,
            movieTitle = input.tvShowImage,
            movieDuration = 0,
            voteAverage = input.tvShowVoteAverage,
            releaseDate = input.tvShowReleaseDate,
            mediaType = Constants.TV_SHOWS
        )
    }
}
