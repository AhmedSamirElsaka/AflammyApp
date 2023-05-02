package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.series.TopRatedSeriesEntity
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class TopRatedSeriesMapper @Inject constructor() : Mapper<TopRatedSeriesEntity, Media> {
    override fun map(input: TopRatedSeriesEntity): Media {
        return Media(
            mediaID = input.id,
            mediaName = input.name,
            mediaImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl,
            mediaRate = 0f,
            mediaDate = "",
            mediaType = MediaType.TV_SHOW.value,
        )
    }
}