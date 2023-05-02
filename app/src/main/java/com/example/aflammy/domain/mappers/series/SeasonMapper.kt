package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.SeasonDto
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.models.Season
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class SeasonMapper @Inject constructor(
    private val episodeMapper: EpisodeMapper
) : Mapper<SeasonDto, Season> {
    override fun map(input: SeasonDto): Season {
        return Season(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            input.name ?: "",
            input.airDate ?: "",
            input.seasonNumber ?: 0,
            input.episodeCount ?: 0,
            input.overview ?: "",
            input.episodes?.map {
                episodeMapper.map(it)
            } ?: emptyList()
        )
    }
}
