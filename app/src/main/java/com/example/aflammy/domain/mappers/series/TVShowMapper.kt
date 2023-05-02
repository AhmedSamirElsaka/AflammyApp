package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class TVShowMapper @Inject constructor() : Mapper<TvShowsDTO, Media> {
    override fun map(input: TvShowsDTO): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            MediaType.TV_SHOW.value,
            input.originalName ?: "",
            input.firstAirDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0F,
        )
    }
}