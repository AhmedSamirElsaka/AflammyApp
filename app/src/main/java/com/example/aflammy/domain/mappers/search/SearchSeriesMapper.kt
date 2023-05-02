package com.example.aflammy.domain.mappers.search

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.TvShowsDTO
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.utilities.Constants
import javax.inject.Inject


class SearchSeriesMapper @Inject constructor() : Mapper<TvShowsDTO, Media> {
    override fun map(input: TvShowsDTO): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.backdropPath,
            Constants.TV_SHOWS,
            input.originalName ?: "",
            input.firstAirDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0F,
        )
    }
}