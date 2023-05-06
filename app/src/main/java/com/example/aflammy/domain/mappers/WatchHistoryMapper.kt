package com.example.aflammy.domain.mappers

import com.example.aflammy.data.local.database.entity.WatchHistoryEntity
import com.example.aflammy.ui.profile.watchhistory.MediaHistoryUiState
import javax.inject.Inject


class WatchHistoryMapper @Inject constructor() : Mapper<WatchHistoryEntity, MediaHistoryUiState> {
    override fun map(input: WatchHistoryEntity): MediaHistoryUiState {
        return MediaHistoryUiState(
            input.id,
            input.posterPath,
            input.movieTitle,
            input.voteAverage,
            input.releaseDate,
            input.movieDuration,
            input.mediaType,
        )
    }
}