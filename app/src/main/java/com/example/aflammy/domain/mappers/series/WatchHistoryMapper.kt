package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.WatchHistoryEntity
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.models.TvShowDetails
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class WatchHistoryMapper @Inject constructor(): Mapper<TvShowDetails, WatchHistoryEntity> {
    override fun map(input: TvShowDetails): WatchHistoryEntity {
        return WatchHistoryEntity(
            id = input.tvShowId,
            posterPath = input.tvShowImage,
            movieTitle = input.tvShowName,
            movieDuration = input.tvShowSeasonsNumber,
            voteAverage = input.tvShowVoteAverage,
            releaseDate = input.tvShowReleaseDate,
            mediaType = MediaType.TV_SHOW.value
        )
    }

}