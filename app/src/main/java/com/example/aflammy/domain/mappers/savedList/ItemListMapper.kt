package com.example.aflammy.domain.mappers.savedList

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.remote.response.DailyTrendingDto
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import com.example.aflammy.utilities.Constants
import javax.inject.Inject


class ItemListMapper @Inject constructor() : Mapper<DailyTrendingDto, Media> {
    override fun map(input: DailyTrendingDto): Media {
        return Media(
            input.id ?: 0,
            BuildConfig.IMAGE_BASE_PATH + input.posterPath,
            mediaType = input.mediaType ?: Constants.MOVIE,
            input.originalLanguage ?: input.originalTitle ?: "",
            input.releaseDate?.substringBefore('-') ?: "",
            input.voteAverage?.toFloat() ?: 0F,
        )
    }
}