package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.episode.EpisodeDto
import com.example.aflammy.domain.models.Episode
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class EpisodeMapper @Inject constructor() : Mapper<EpisodeDto, Episode> {
    override fun map(input: EpisodeDto): Episode {
        return Episode(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.stillPath,
            input.name ?: "",
            input.runtime ?: 0,
            input.airDate ?: "",
            input.voteAverage ?: 0.0,
            input.voteCount.toString(),
            input.overview ?: "",
            input.episodeNumber ?: 1,
        )
    }
}