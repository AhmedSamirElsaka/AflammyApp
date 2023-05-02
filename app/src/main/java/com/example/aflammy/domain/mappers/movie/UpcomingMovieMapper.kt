package com.example.aflammy.domain.mappers.movie

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.movie.UpcomingMovieEntity
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class UpcomingMovieMapper @Inject constructor() : Mapper<UpcomingMovieEntity, Media> {
    override fun map(input: UpcomingMovieEntity): Media {
        return Media(
            mediaID = input.id,
            mediaName = input.name,
            mediaImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl,
            mediaRate = 0f,
            mediaDate = "",
            mediaType = MediaType.MOVIE.value,
        )
    }
}