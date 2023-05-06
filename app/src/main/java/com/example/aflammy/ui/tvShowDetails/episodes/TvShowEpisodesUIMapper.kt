package com.example.aflammy.ui.tvShowDetails.episodes

import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.domain.models.Episode
import javax.inject.Inject


class TvShowEpisodesUIMapper @Inject constructor() : Mapper<Episode, EpisodeUIState> {
    override fun map(input: Episode): EpisodeUIState {
        return EpisodeUIState(
            episodeId = input.episodeId,
            imageUrl = input.imageUrl,
            episodeName = input.episodeName,
            episodeDuration = input.episodeDuration,
            episodeDate = input.episodeDate,
            episodeRate = input.episodeRate,
            episodeTotalReviews = input.episodeTotalReviews,
            episodeDescription = input.episodeDescription,
            episodeNumber = input.episodeNumber
        )
    }
}
